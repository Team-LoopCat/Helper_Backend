package org.example.global.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.Role;
import org.example.domain.auth.spi.JwtPort;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService implements JwtPort {
    private final JwtProperties jwtProperties;

    @Override
    public String GenerateAccess(String userId, Role role) {
        Long now = (new Date()).getTime();
        Date expireTime = new Date(now + jwtProperties.access_time());

        return Jwts.builder()
                .setSubject(userId)
                .claim("type", "access")
                .claim("role", role)
                .setExpiration(expireTime)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secret())
                .compact();
    }

    @Override
    public String GenerateRefresh(String userId) {
        Long now = (new Date()).getTime();
        Date expireTime = new Date(now + jwtProperties.refresh_time());

        return Jwts.builder()
                .setSubject(userId)
                .claim("type", "refresh")
                .setExpiration(expireTime)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secret())
                .compact();
    }
}
