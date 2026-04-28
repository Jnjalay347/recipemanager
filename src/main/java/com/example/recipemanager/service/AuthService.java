package com.example.recipemanager.service;

import com.example.recipemanager.controller.AuthController.TokenResponse;
import com.example.recipemanager.entity.User;

import com.example.recipemanager.repository.UserRepository;
import com.example.recipemanager.security.JwtService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public TokenResponse register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalStateException("Email already registered");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saved = userRepository.save(user);
        String token = jwtService.generateToken(saved.getId(), saved.getEmail());
        return new TokenResponse(token);
    }

    public TokenResponse login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new BadCredentialsException("Invalid credentials"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }
        String token = jwtService.generateToken(user.getId(), user.getEmail());
        return new TokenResponse(token);
    }
}
