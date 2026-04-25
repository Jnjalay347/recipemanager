package com.example.recipemanager.repository;

import com.example.recipemanager.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RecipeRepository extends MongoRepository<User, String> {
    // find by title
    Optional<User> findByTitle(String title);

    // find by category
    Optional<User> findByCategory(String category);
}
