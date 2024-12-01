package com.example.forma1restapi.Services;

import com.example.forma1restapi.Models.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;


import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private final String secretKeyString = "6ea8c3ff63ad80a9a594fd2571c705ecb84cf6fbc0cc46c22f9c5af6acdda312";
    private final SecretKey secretKey = new SecretKeySpec(secretKeyString.getBytes(), SignatureAlgorithm.HS512.getJcaName());
    private final int jwtExp = 7200000; // 2 hours

    public String generateToken(String username, Role role){
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role.name());
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String username){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExp))
                .signWith(secretKey)
                .compact();
    }

    public String extractUsername(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);

            return true;
        } catch (Exception e){
            return false;
        }
    }

    public String extractRole(String token){
        Claims claims = Jwts.parserBuilder().setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.get("role", String.class);
    }

}
