package com.example.recipemanager.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "recipes")
public class Recipe {
    @Id
    private String id;

    @Field
    private String title;

    @Field
    private String description;

    @Field
    private List<String> ingredients;

    @Field
    private int prepTime;

    @Field
    private String category;
}