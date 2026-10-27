package com.skillquest.backend;

import com.skillquest.backend.controller.HealthController;
import com.skillquest.backend.dto.*;
import com.skillquest.backend.dto.skilldtos.*;
import com.skillquest.backend.dto.skillmoduledtos.*;
import com.skillquest.backend.exception.ApiException;
import com.skillquest.backend.model.*;
import com.skillquest.backend.model.enums.*;
import com.skillquest.backend.repository.*;
import com.skillquest.backend.service.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("SkillQuest Backend Comprehensive Test Suite (Java 21)")
class SkillQuestApplicationTests {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private SkillRepository skillRepository;

    @Mock
    private UserSkillRepository userSkillRepository;

    @Mock
    private SkillTaskRepository skillTaskRepository;

    @Mock
    private UserTaskRepository userTaskRepository;

    @Mock
    private ActivityLogRepository activityLogRepository;

    @Mock
    private SkillModuleRepository skillModuleRepository;

    @Mock
    private UserService userService;

    @Mock
    private ActivityLogService activityLogService;

    @InjectMocks
    private AuthService authService;

    @InjectMocks
    private UserSkillService userSkillService;

    @InjectMocks
    private UserTaskService userTaskService;

    @InjectMocks
    private SkillService skillService;

    @InjectMocks
    private SearchSkillService searchSkillService;

    @InjectMocks
    private SkillModuleService skillModuleService;

    private User testUser;
    private Skill testSkill;

    @BeforeEach
    void setUp() {
        testUser = new User("John Doe", "john@example.com", "hashed_password_123");
        ReflectionTestUtils.setField(testUser, "id", 1L);
        testUser.setUserXp(100);
        testUser.setCurrentStreak(2);
        testUser.setLongestStreak(5);

        testSkill = new Skill();
        ReflectionTestUtils.setField(testSkill, "id", 10L);
        testSkill.setSlug("java-programming");
        testSkill.setName("Java Programming");
        testSkill.setCategory("Programming");
        testSkill.setDescription("Master modern Java 21 features");
        testSkill.setIcon("java-icon");
        testSkill.setDifficulty(Difficulty.INTERMEDIATE);
        testSkill.setEstimatedHours(25);
    }

    // TEST 1: AuthService - Signup Success
    @Test
    @DisplayName("1. AuthService: Should successfully register a new user, normalize email, and return JWT AuthResponse")
    void shouldSignupNewUserSuccessfully() {
        var request = new SignupRequest("  John Doe  ", "  JOHN@Example.com ", "password123");

        when(userRepository.existsByEmail("john@example.com")).thenReturn(false);
        when(passwordEncoder.encode("password123")).thenReturn("encoded_secret");
        when(jwtService.generateToken("john@example.com")).thenReturn("mock.jwt.token");

        AuthResponse response = authService.signup(request);

        assertAll("Verify Signup Response and Normalized Fields",
            () -> assertNotNull(response),
            () -> assertEquals("mock.jwt.token", response.token()),
            () -> assertEquals("John Doe", response.user().name()),
            () -> assertEquals("john@example.com", response.user().email()),
            () -> assertEquals(0, response.user().userXp())
        );

        var userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository, times(1)).save(userCaptor.capture());
        assertEquals("encoded_secret", userCaptor.getValue().getPasswordHash());
    }

    // TEST 2: AuthService - Duplicate Email Signup Rejection
    @Test
    @DisplayName("2. AuthService: Should throw 409 CONFLICT ApiException when signing up with an existing email")
    void shouldThrowConflictWhenEmailAlreadyExistsOnSignup() {
        var request = new SignupRequest("John Doe", "john@example.com", "password123");
        when(userRepository.existsByEmail("john@example.com")).thenReturn(true);

        ApiException ex = assertThrows(ApiException.class, () -> authService.signup(request));

        assertEquals(HttpStatus.CONFLICT, ex.getHttpStatus());
        assertEquals("An account with this email already exists", ex.getMessage());
        verify(userRepository, never()).save(any());
    }

    // TEST 3: AuthService - Login Authentication & Invalid Password Handling
    @Test
    @DisplayName("3. AuthService: Should authenticate valid login and reject invalid password with 401 UNAUTHORIZED")
    void shouldAuthenticateValidUserAndRejectInvalidPassword() {
        var validRequest = new LoginRequest("john@example.com", "correct_password");
        var invalidRequest = new LoginRequest("john@example.com", "wrong_password");

        when(userRepository.findByEmail("john@example.com")).thenReturn(Optional.of(testUser));
        when(passwordEncoder.matches("correct_password", "hashed_password_123")).thenReturn(true);
        when(passwordEncoder.matches("wrong_password", "hashed_password_123")).thenReturn(false);
        when(jwtService.generateToken("john@example.com")).thenReturn("valid.jwt.token");

        // Valid login assertion
        AuthResponse successResponse = authService.login(validRequest);
        assertEquals("valid.jwt.token", successResponse.token());
        assertEquals(100, successResponse.user().userXp());

        // Invalid password assertion
        ApiException ex = assertThrows(ApiException.class, () -> authService.login(invalidRequest));
        assertEquals(HttpStatus.UNAUTHORIZED, ex.getHttpStatus());
        assertEquals("Invalid email or password.", ex.getMessage());
    }

    // TEST 4: JwtService - Token Generation, Subject Extraction & Expiration
    @Test
    @DisplayName("4. JwtService: Should generate valid HMAC-SHA256 JWT token, extract email, and reject tampered tokens")
    void shouldGenerateValidateAndExtractEmailFromJwtToken() {
        // 256-bit Base64-encoded secret key for JJWT 0.12.6
        String base64Secret = "c2tpbGxxdWVzdC1zdXBlci1zZWNyZXQta2V5LWZvci1qd3QtdGVzdGluZy0yMDI2";
        JwtService localJwtService = new JwtService(base64Secret, 3600000L); // 1 hour

        String token = localJwtService.generateToken("john@example.com");

        assertAll("JWT Token Validation & Extraction",
            () -> assertNotNull(token),
            () -> assertTrue(localJwtService.isValid(token)),
            () -> assertEquals("john@example.com", localJwtService.extractEmail(token)),
            () -> assertFalse(localJwtService.isValid(token + "tampered")),
            () -> assertFalse(localJwtService.isValid("invalid.token.string"))
        );
    }

    // TEST 5: UserSkillService - Start Learning Skill & Prevent Duplicate Enrollment
    @Test
    @DisplayName("5. UserSkillService: Should enroll user in a new skill, update lastActiveSkill, and block duplicate enrollment")
    void shouldStartLearningSkillAndPreventDuplicateEnrollment() {
        var startRequest = new StartSkillRequest(10L);

        when(userService.getUser("john@example.com")).thenReturn(testUser);
        when(userSkillRepository.existsByUserIdAndSkillId(1L, 10L)).thenReturn(false);
        when(skillRepository.getReferenceById(10L)).thenReturn(testSkill);

        userSkillService.startLearningSkill("john@example.com", startRequest);

        var userSkillCaptor = ArgumentCaptor.forClass(UserSkill.class);
        verify(userSkillRepository, times(1)).save(userSkillCaptor.capture());

        UserSkill savedUserSkill = userSkillCaptor.getValue();
        assertEquals(SkillStatus.ACTIVE, savedUserSkill.getStatus());
        assertEquals(testUser, savedUserSkill.getUser());
        assertEquals(testSkill, savedUserSkill.getSkill());
        assertEquals(10L, testUser.getLastActiveSkill());

        // Verify duplicate check throws BAD_REQUEST
        when(userSkillRepository.existsByUserIdAndSkillId(1L, 10L)).thenReturn(true);
        ApiException duplicateEx = assertThrows(ApiException.class,
            () -> userSkillService.startLearningSkill("john@example.com", startRequest));
        assertEquals(HttpStatus.BAD_REQUEST, duplicateEx.getHttpStatus());
    }

    // TEST 6: UserTaskService - Complete Task, Award XP & Trigger Activity Log
    @Test
    @DisplayName("6. UserTaskService: Should mark task completed, award XP to user, and log daily activity")
    void shouldCompleteUserTaskAwardXpAndLogActivity() {
        var userSkill = new UserSkill();
        ReflectionTestUtils.setField(userSkill, "id", 50L);
        userSkill.setUser(testUser);
        userSkill.setSkill(testSkill);

        var skillTask = new SkillTask();
        ReflectionTestUtils.setField(skillTask, "id", 100L);
        skillTask.setTitle("Learn Virtual Threads");
        skillTask.setTaskXp(75);

        when(userService.getUser("john@example.com")).thenReturn(testUser);
        when(userSkillRepository.findByUserIdAndSkillId(1L, 10L)).thenReturn(Optional.of(userSkill));
        when(userTaskRepository.existsByUserSkillIdAndTaskId(50L, 100L)).thenReturn(false);
        when(skillTaskRepository.findById(100L)).thenReturn(Optional.of(skillTask));

        userTaskService.addUserTask("john@example.com", 100L, 10L);

        assertAll("Verify Task Completion Effects",
            () -> assertEquals(175, testUser.getUserXp()), // 100 initial + 75 task XP
            () -> assertEquals(10L, testUser.getLastActiveSkill())
        );

        verify(userTaskRepository, times(1)).save(any(UserTask.class));
        verify(activityLogService, times(1)).logDayActivity(testUser);
    }

    // TEST 7: ActivityLogService - Consecutive Day Streak Calculation & Heatmap
    @Test
    @DisplayName("7. ActivityLogService: Should increment streak when active yesterday, update longestStreak, and map Heatmap")
    void shouldUpdateStreakAndGenerateHeatmapData() {
        var realActivityLogService = new ActivityLogService(activityLogRepository, userService, userRepository);
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        testUser.setCurrentStreak(5);
        testUser.setLongestStreak(5);

        // Simulate first task of today, with activity recorded yesterday
        when(activityLogRepository.findByUserAndActivityDate(testUser, today)).thenReturn(Optional.empty());
        when(activityLogRepository.findByUserAndActivityDate(testUser, yesterday)).thenReturn(Optional.of(new ActivityLog()));

        realActivityLogService.logDayActivity(testUser);

        assertAll("Streak Increment Verification",
            () -> assertEquals(6, testUser.getCurrentStreak()),
            () -> assertEquals(6, testUser.getLongestStreak())
        );
        verify(activityLogRepository, times(1)).save(any(ActivityLog.class));
        verify(userRepository, times(1)).save(testUser);

        // Verify Heatmap data mapping
        var sampleLog = new ActivityLog();
        sampleLog.setUser(testUser);
        sampleLog.setActivityDate(today);
        sampleLog.setTasksCompleted(4);

        when(userService.getUser("john@example.com")).thenReturn(testUser);
        when(activityLogRepository.findByUserAndActivityDateBetween(eq(testUser), any(LocalDate.class), eq(today)))
            .thenReturn(List.of(sampleLog));

        List<HeatmapResponse> heatmap = realActivityLogService.getHeatmapData("john@example.com");
        assertEquals(1, heatmap.size());
        assertEquals(4, heatmap.getFirst().count()); // Uses Java 21 SequencedCollection.getFirst()
        assertEquals(today, heatmap.getFirst().date());
    }

    // TEST 8: SkillService & SearchSkillService - Browse & Search Projections
    @Test
    @DisplayName("8. SkillService & SearchSkillService: Should map SkillSummaryProjection to DTOs and format search slugs")
    void shouldBrowseAndSearchSkillsCorrectly() {
        SkillSummaryProjection mockProjection = new SkillSummaryProjection() {
            @Override public Skill getSkill() { return testSkill; }
            @Override public SkillStatus getStatus() { return SkillStatus.ACTIVE; }
            @Override public Integer getSkillXp() { return 500; }
            @Override public Integer getDoneTasks() { return 3; }
            @Override public Integer getTotalTasks() { return 10; }
        };

        when(skillRepository.findAvailabeSkillsForUser(1L, SkillStatus.COMPLETED, PageRequest.of(0, 5)))
            .thenReturn(List.of(mockProjection));

        List<SkillSummaryDto> browseResult = skillService.getBrowseSkills(1L, 5);
        assertEquals(1, browseResult.size());
        assertEquals("java-programming", browseResult.getFirst().slug());
        assertEquals(500, browseResult.getFirst().skillXp());
        assertEquals(3, browseResult.getFirst().doneTasks());

        // Test SearchSkillService slug formatting ("java programming" -> "java-programming")
        when(userService.getUser("john@example.com")).thenReturn(testUser);
        when(skillRepository.findSkillsBySkillName(1L, "java-programming"))
            .thenReturn(List.of(mockProjection));

        List<SkillSummaryDto> searchResult = searchSkillService.getSkillsBySkillSlug("john@example.com", "  java programming ");
        assertEquals(1, searchResult.size());
        assertEquals("Java Programming", searchResult.getFirst().name());
    }

    // TEST 9: SkillModuleService & HealthController - Module Hierarchy & Health
    @Test
    @DisplayName("9. SkillModuleService & HealthController: Should map nested modules/tasks/resources and return health OK")
    void shouldMapSkillModulesAndVerifyHealthEndpoint() {
        var module = new SkillModule();
        ReflectionTestUtils.setField(module, "id", 20L);
        module.setTitle("Module 1: Java 21 Basics");
        module.setSkill(testSkill);

        var task = new SkillTask();
        ReflectionTestUtils.setField(task, "id", 200L);
        task.setTitle("Record Patterns & Pattern Matching");
        task.setDescription("Learn JEP 440 and JEP 441");
        task.setEstMinutes(30);
        task.setFormat(TaskFormat.PRACTICE);
        task.setTaskXp(50);

        var resource = new Resource();
        ReflectionTestUtils.setField(resource, "id", 300L);
        resource.setTitle("Official Java 21 Docs");
        resource.setUrl("https://docs.oracle.com/en/java/javase/21/");
        resource.setFree(true);

        SkillTaskProjection taskProjection = new SkillTaskProjection() {
            @Override public SkillTask getSkillTask() { return task; }
            @Override public Boolean getIsDone() { return true; }
            @Override public Instant getCompletedAt() { return Instant.parse("2026-10-01T10:00:00Z"); }
            @Override public Resource getResource() { return resource; }
        };

        when(userService.getUser("john@example.com")).thenReturn(testUser);
        when(skillModuleRepository.getSkillModulesBySkillId(10L)).thenReturn(List.of(module));
        when(skillTaskRepository.getTasksBySkillModuleId(1L, 20L)).thenReturn(List.of(taskProjection));

        List<SkillModuleResponse> moduleResponses = skillModuleService.getSkillModulesOfSkill("john@example.com", 10L);

        assertEquals(1, moduleResponses.size());
        SkillModuleResponse modDto = moduleResponses.getFirst();
        assertEquals("Module 1: Java 21 Basics", modDto.title());
        assertEquals(1, modDto.tasks().size());

        TaskResponseDto taskDto = modDto.tasks().getFirst();
        assertTrue(taskDto.isDone());
        assertNotNull(taskDto.resource());
        assertEquals("Official Java 21 Docs", taskDto.resource().title());

        // HealthController check
        var healthController = new HealthController();
        assertEquals(Map.of("status", "ok"), healthController.health());
    }
}