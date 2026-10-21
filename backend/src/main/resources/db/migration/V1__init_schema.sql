CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    created_at DATETIME(6) NOT NULL,
    current_streak INT NOT NULL DEFAULT 0,
    longest_streak INT NOT NULL DEFAULT 0,
    last_active_date DATE NULL,
    user_xp INT NOT NULL DEFAULT 0,
    last_active_skill BIGINT NULL,
    CONSTRAINT uk_users_email UNIQUE (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE skills (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    slug VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    description TEXT NULL,
    icon VARCHAR(50) NULL,
    difficulty VARCHAR(20) NOT NULL DEFAULT 'BEGINNER',
    estimated_hours INT NOT NULL DEFAULT 0,
    CONSTRAINT uk_skills_slug UNIQUE (slug)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE skill_modules (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    skill_id BIGINT NOT NULL,
    title VARCHAR(150) NOT NULL,
    position INT NOT NULL,
    CONSTRAINT fk_modules_skill FOREIGN KEY (skill_id) REFERENCES skills (id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE skill_tasks (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    module_id BIGINT NOT NULL,
    title VARCHAR(200) NOT NULL,
    description TEXT NULL,
    position INT NOT NULL,
    est_minutes INT NOT NULL DEFAULT 0,
    format VARCHAR(20) NOT NULL DEFAULT 'READ',
    task_xp INT NOT NULL DEFAULT 0,
    CONSTRAINT fk_tasks_module FOREIGN KEY (module_id) REFERENCES skill_modules (id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE resources (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    skill_id BIGINT NOT NULL,
    task_id BIGINT NULL,
    title VARCHAR(200) NOT NULL,
    url VARCHAR(1000) NOT NULL,
    type VARCHAR(20) NOT NULL DEFAULT 'ARTICLE',
    is_free BIT(1) NOT NULL DEFAULT b'1',
    CONSTRAINT fk_resources_skill FOREIGN KEY (skill_id) REFERENCES skills (id) ON DELETE CASCADE,
    CONSTRAINT fk_resources_task FOREIGN KEY (task_id) REFERENCES skill_tasks (id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE user_skills (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    skill_id BIGINT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    started_at DATETIME(6) NOT NULL,
    completed_at DATETIME(6) NULL,
    CONSTRAINT uk_user_skill UNIQUE (user_id, skill_id),
    CONSTRAINT fk_user_skills_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_user_skills_skill FOREIGN KEY (skill_id) REFERENCES skills (id) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE user_tasks (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_skill_id BIGINT NOT NULL,
    task_id BIGINT NOT NULL,
    is_done BIT(1) NOT NULL DEFAULT b'0',
    completed_at DATETIME(6) NULL,
    CONSTRAINT uk_user_task UNIQUE (user_skill_id, task_id),
    CONSTRAINT fk_user_tasks_user_skill FOREIGN KEY (user_skill_id) REFERENCES user_skills (id) ON DELETE CASCADE,
    CONSTRAINT fk_user_tasks_task FOREIGN KEY (task_id) REFERENCES skill_tasks (id) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE activity_log (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    activity_date DATE NOT NULL,
    tasks_completed INT NOT NULL DEFAULT 0,
    CONSTRAINT uk_user_day UNIQUE (user_id, activity_date),
    CONSTRAINT fk_activity_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;