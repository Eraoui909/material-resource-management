package com.gestion_ressource.micro_authentification.helper;

import com.gestion_ressource.micro_authentification.service.UserAuth;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class JwtHelper {

    @Value("${project.Auth.JWT.SecretKey}")
    private String jwtSecret;

//    @Value("${project.Auth.JWT.ExpirationMS}")
    private int jwtExpirationMs = 199282;

    public String generateJwtToken(Authentication authentication) {
        UserAuth userPrincipal = (UserAuth) authentication.getPrincipal();
        List<String> list = new ArrayList<>();

        userPrincipal.getAuthorities().forEach(
                role -> {
                    list.add(role.getAuthority());
                }
        );

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .claim("roles", list)
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }catch (Exception e) {
            log.error("We've found an error while parsing JWT token: {}", e.getMessage());
        }
        return false;
    }
}
