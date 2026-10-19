package com.skillquest.backend.model;

import com.skillquest.backend.model.enums.TaskFormat;

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
import jakarta.persistence.Table;

@Entity 
@Table(name = "skill_tasks")
public class SkillTask {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "module_id", nullable = false)
    private SkillModule module;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private int position;

    @Column(nullable = false)
    private int estMinutes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(20)")
    private TaskFormat format = TaskFormat.READ;

    @Column(nullable = false)
    private int taskXp = 0;

    public Long getId() { return id; }
    public SkillModule getModule() { return module; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getPosition() { return position; }
    public int getEstMinutes() { return estMinutes; }
    public TaskFormat getFormat() { return format; }
    public int getTaskXp() { return taskXp; }

    public void setModule(SkillModule module) { this.module = module; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setPosition(int position) { this.position = position; }
    public void setEstMinutes(int estMinutes) { this.estMinutes = estMinutes; }
    public void setFormat(TaskFormat format) { this.format = format; }
    public void setTaskXp(int taskXp) { this.taskXp = taskXp; }
}
