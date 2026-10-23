package com.skillquest.backend.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillquest.backend.model.ActivityLog;
import com.skillquest.backend.model.User;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
    Optional<ActivityLog> findByUserAndActivityDate(User user, LocalDate date);

    List<ActivityLog> findByUserAndActivityDateBetween(User user, LocalDate startDate, LocalDate endDate);
}
