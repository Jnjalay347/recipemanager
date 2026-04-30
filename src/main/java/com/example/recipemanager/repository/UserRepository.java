package com.example.recipemanager.repository;

import com.example.recipemanager.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    // find by username
    Optional<User> findByUsername(String username);

    // find by email
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
