package com.example.recipemanager.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "recipes")
@Data
public class Recipe {
    @Id
    private String id;

    @Field
    private String title;

    @Field
    private String description;

    @Field
    private List<String> ingredients = new ArrayList<>();

    @Field
    private int prepTime;

    @Field
    private String category;
}