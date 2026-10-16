package com.skillquest.backend.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity 
@Table(name = "skill_modules")
public class SkillModule {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false)
    private int position;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("position ASC")
    private List<SkillTask> tasks = new ArrayList<>();

    public Long getId() { return id; }
    public Skill getSkill() { return skill; }
    public String getTitle() { return title; }
    public int getPosition() { return position; }
    public List<SkillTask> getTasks() { return tasks; }

    public void setSkill(Skill skill) { this.skill = skill; }
    public void setTitle(String title) { this.title = title; }
    public void setPosition(int position) { this.position = position; }

    public void addTask(SkillTask task) {
        tasks.add(task);
        task.setModule(this);
    }
}
