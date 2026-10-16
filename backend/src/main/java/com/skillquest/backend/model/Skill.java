package com.skillquest.backend.model;

import java.util.List;
import java.util.ArrayList;

import com.skillquest.backend.model.enums.Difficulty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity 
@Table(name = "skills")
public class Skill {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String slug;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 50)
    private String icon;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(20)")
    private Difficulty difficulty = Difficulty.BEGINNER;

    @Column(nullable = false)
    private int estimatedHours;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("position ASC")
    private List<SkillModule> modules = new ArrayList<>();

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resource> resources = new ArrayList<>();

    public Long getId() { return id; }
    public String getSlug() { return slug; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getIcon() { return icon; }
    public Difficulty getDifficulty() { return difficulty; }
    public int getEstimatedHours() { return estimatedHours; }
    public List<SkillModule> getModules() { return modules; }
    public List<Resource> getResources() { return resources; }

    public void setSlug(String slug) { this.slug = slug; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setDescription(String description) { this.description = description; }
    public void setIcon(String icon) { this.icon = icon; }
    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }
    public void setEstimatedHours(int estimatedHours) { this.estimatedHours = estimatedHours; }

    public void addModule(SkillModule module) {
        modules.add(module);
        module.setSkill(this);
    }

    public void addResource(Resource resource) {
        resources.add(resource);
        resource.setSkill(this);
    }
}
