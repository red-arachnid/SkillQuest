package com.skillquest.backend.model;

import java.time.Instant;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity 
@Table(
    name = "user_tasks",
    uniqueConstraints = @UniqueConstraint(name = "uk_user_task", columnNames = {"user_skill_id", "task_id"})
)
public class UserTask {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_skill_id", nullable = false)
    private UserSkill userSkill;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task_id", nullable = false)
    private SkillTask task;

    private LocalDate scheduledDate;

    @Column(name = "is_done", nullable = false)
    private boolean done = false;

    private Instant completedAt;

    public Long getId() { return id; }
    public UserSkill getUserSkill() { return userSkill; }
    public SkillTask getTask() { return task; }
    public LocalDate getScheduledDate() { return scheduledDate; }
    public boolean isDone() { return done; }
    public Instant getCompletedAt() { return completedAt; }

    public void setUserSkill(UserSkill userSkill) { this.userSkill = userSkill; }
    public void setTask(SkillTask task) { this.task = task; }
    public void setScheduledDate(LocalDate scheduledDate) { this.scheduledDate = scheduledDate; }
    public void setDone(boolean done) { this.done = done; }
    public void setCompletedAt(Instant completedAt) { this.completedAt = completedAt; }
}
