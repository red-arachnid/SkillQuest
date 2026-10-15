package com.skillearn.backend.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skillearn.backend.dto.*;
import com.skillearn.backend.exception.ApiException;
import com.skillearn.backend.model.User;
import com.skillearn.backend.repository.UserRepository;

@Service 
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse signup(SignupRequest request) {
        String email = request.email().trim().toLowerCase();

        if (userRepository.existsByEmail(email)) {
            throw new ApiException(HttpStatus.CONFLICT, "An account with this email already exists");
        }

        User user = new User(request.name().trim(), email, passwordEncoder.encode(request.password()));
        userRepository.save(user);

        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
}
