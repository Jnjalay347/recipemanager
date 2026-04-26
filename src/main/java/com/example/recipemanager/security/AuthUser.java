package com.example.recipemanager.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthUser {

    private final String userId;
    private final String email;
}
