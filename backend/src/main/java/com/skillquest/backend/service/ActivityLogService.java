package com.skillquest.backend.service;

import com.skillquest.backend.repository.UserRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillquest.backend.dto.HeatmapResponse;
import com.skillquest.backend.model.ActivityLog;
import com.skillquest.backend.model.User;
import com.skillquest.backend.repository.ActivityLogRepository;

import jakarta.transaction.Transactional;

@Service 
public class ActivityLogService {
    private final UserRepository userRepository;
    private final ActivityLogRepository activityLogRepository;
    private final UserService userService;

    public ActivityLogService(ActivityLogRepository activityLogRepository, UserService userService, UserRepository userRepository) {
        this.activityLogRepository = activityLogRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Transactional 
    public void logDayActivity(User user) {
        LocalDate today = LocalDate.now();

        Optional<ActivityLog> todayLogOpt = activityLogRepository.findByUserAndActivityDate(user, today);

        if (todayLogOpt.isPresent()) {
            ActivityLog log = todayLogOpt.get();
            log.setTasksCompleted(log.getTasksCompleted() + 1);
            activityLogRepository.save(log);
        }
        else {
            ActivityLog newLog = new ActivityLog();
            newLog.setUser(user);
            newLog.setActivityDate(today);
            newLog.setTasksCompleted(1);
            activityLogRepository.save(newLog);
            updateStreak(user, today);
        }
    }

    public List<HeatmapResponse> getHeatmapData(String userEmail) {
        User user = userService.getUser(userEmail);

        LocalDate endDate = LocalDate.now();
        LocalDate starDate = endDate.minusDays(31);

        List<ActivityLog> logs = activityLogRepository.findByUserAndActivityDateBetween(user, starDate, endDate);

        return logs.stream()
            .map(log -> new HeatmapResponse(log.getActivityDate(), log.getTasksCompleted()))
            .toList();
    }

    private void updateStreak(User user, LocalDate today) {
        LocalDate yesterday = today.minusDays(1);
        boolean hadActivityYesterday = activityLogRepository.findByUserAndActivityDate(user, yesterday).isPresent();

        if (hadActivityYesterday) {
            user.setCurrentStreak(user.getCurrentStreak() + 1);
        }
        else {
            user.setCurrentStreak(1);
        }

        if (user.getCurrentStreak() > user.getLongestStreak()) {
            user.setLongestStreak(user.getCurrentStreak());
        }
        userRepository.save(user);
    }
}
