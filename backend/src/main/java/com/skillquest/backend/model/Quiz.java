package com.skillquest.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "quizzes")
public class Quiz {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task_id", nullable = false)
    private SkillTask task;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String question;

    @Column(nullable = false)
    private boolean answer;

    public Long getId() { return id; }
    public Skill getSkill() { return skill; }
    public SkillTask getSkillTask() { return task; }
    public String getQuestion() { return question; }
    public boolean getAnswer() { return answer; }

    public void setSkill(Skill skill) { this.skill = skill; }
    public void setSkillTask(SkillTask task) { this.task = task; }
    public void setQuestion(String question) { this.question = question; }
    public void setAnswer(boolean answer) { this.answer = answer; }
}
