package com.example.forma1restapi.Services;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class JwtBlacklist {
    private final Set<String> blacklistedTokens = new HashSet<>();

    public void blacklistToken(String token) {
        blacklistedTokens.add(token);
    }

    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.contains(token);
    }
}
