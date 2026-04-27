package com.example.recipemanager.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "users")
@Data
public class User {
    @Id
    private String id;

    @Field
    @Indexed(unique = true)
    private String username;

    @Field
    private String password;

    @Field
    private String email;

    @Field
    private List<String> roles;
}