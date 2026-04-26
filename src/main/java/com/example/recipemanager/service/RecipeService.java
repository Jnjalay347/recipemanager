package com.example.recipemanager.service;

import com.example.recipemanager.entity.Recipe;
import com.example.recipemanager.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepo;

    // CREATE | creates recipe
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepo.save(recipe);
    }

    // READ ALL | gets all recipes
    public List<Recipe> getAllRecipes() {
        return recipeRepo.findAll();
    }

    // READ ONE | gets one recipe
    public Recipe getOneRecipe(String recipeId) {
        return recipeRepo.findById(recipeId)
                // 404, IF NOT FOUND
                .orElseThrow(() -> new RuntimeException("Recipe not found: " + recipeId));
    }

    // UPDATE | updates a recipe
    public Recipe updateRecipe(String recipeId, Recipe recipe) {
        Recipe currentRecipe = getOneRecipe(recipeId);  // 404, IF NOT FOUND

        currentRecipe.setTitle(recipe.getTitle());
        currentRecipe.setDescription(recipe.getDescription());
        currentRecipe.setIngredients(recipe.getIngredients());
        currentRecipe.setPrepTime(recipe.getPrepTime());
        currentRecipe.setCategory(recipe.getCategory());

        return recipeRepo.save(currentRecipe);
    }

    // DELETE | deletes a recipe
    public boolean deleteRecipe(String recipeId) {
        if (recipeRepo.existsById(recipeId)) {
            recipeRepo.deleteById(recipeId);
            return true;
        }
        return false;
    }
}
