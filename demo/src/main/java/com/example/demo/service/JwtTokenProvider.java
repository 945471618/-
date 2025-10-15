package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private final String JWT_SECRET = "your-secret-key";  // 用环境变量管理生产环境的密钥
    private final long JWT_EXPIRATION = 86400000L; // 1天过期

    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
