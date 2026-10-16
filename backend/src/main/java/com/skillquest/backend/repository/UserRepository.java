package com.skillquest.backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.skillquest.backend.model.User;


// Similar to the DbContextRepository in dotnet
// Use function name to fire queries in databases
// Database Table name of User with Primary key of Long
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}

// Jpa Parser convers the function name into sql queries
// findBy"column" => select "column" from User
// existsBy"column" => exists "column" = "email"