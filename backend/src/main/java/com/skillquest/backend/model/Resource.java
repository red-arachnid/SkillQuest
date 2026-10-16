package com.skillquest.backend.model;

import com.skillquest.backend.model.enums.ResourceType;

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
@Table(name = "resources")
public class Resource {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private SkillTask task;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 1000)
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(20)")
    private ResourceType type = ResourceType.ARTICLE;

    @Column(name = "is_free", nullable = false)
    private boolean free = true;

    public Long getId() { return id; }
    public Skill getSkill() { return skill; }
    public SkillTask getTask() { return task; }
    public String getTitle() { return title; }
    public String getUrl() { return url; }
    public ResourceType getType() { return type; }
    public boolean isFree() { return free; }

    public void setSkill(Skill skill) { this.skill = skill; }
    public void setTask(SkillTask task) { this.task = task; }
    public void setTitle(String title) { this.title = title; }
    public void setUrl(String url) { this.url = url; }
    public void setType(ResourceType type) { this.type = type; }
    public void setFree(boolean free) { this.free = free; }
}
