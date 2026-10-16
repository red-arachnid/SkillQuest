package com.skillquest.backend.model;

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
    name = "activity_log",
    uniqueConstraints = @UniqueConstraint(name = "uk_user_day", columnNames = {"user_id", "activity_date"})
)
public class ActivityLog {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "activity_date", nullable = false)
    private LocalDate activityDate;

    @Column(nullable = false)
    private int tasksCompleted = 0;

    public Long getId() { return id; }
    public User getUser() { return user; }
    public LocalDate getActivityDate() { return activityDate; }
    public int getTasksCompleted() { return tasksCompleted; }

    public void setUser(User user) { this.user = user; }
    public void setActivityDate(LocalDate activityDate) { this.activityDate = activityDate; }
    public void setTasksCompleted(int tasksCompleted) { this.tasksCompleted = tasksCompleted; }
}
