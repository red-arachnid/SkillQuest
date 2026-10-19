package com.skillquest.backend.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.skillquest.backend.model.enums.SkillStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity 
@Table(
    name = "user_skills",
    uniqueConstraints = @UniqueConstraint(name = "uk_user_skill", columnNames = {"user_id", "skill_id"})
)
public class UserSkill {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(20)")
    private SkillStatus status = SkillStatus.ACTIVE;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant startedAt = Instant.now();

    private Instant completedAt;

    @OneToMany(mappedBy = "userSkill", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("scheduledDate ASC, id ASC")
    private List<UserTask> tasks = new ArrayList<>();

    public Long getId() { return id; }
    public User getUser() { return user; }
    public Skill getSkill() { return skill; }
    public SkillStatus getStatus() { return status; }
    public Instant getStartedAt() { return startedAt; }
    public Instant getCompletedAt() { return completedAt; }
    public List<UserTask> getTasks() { return tasks; }

    public void setUser(User user) { this.user = user; }
    public void setSkill(Skill skill) { this.skill = skill; }
    public void setStatus(SkillStatus status) { this.status = status; }
    public void setCompletedAt(Instant completedAt) { this.completedAt = completedAt; }

    public void addTask(UserTask task) {
        tasks.add(task);
        task.setUserSkill(this);
    }
}
