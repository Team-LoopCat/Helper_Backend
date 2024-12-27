package org.example.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.Role;
import org.example.global.security.auth.CustomUserDetailService;
import org.example.global.security.exception.ExpiredTokenException;
import org.example.global.security.exception.InvalidRoleException;
import org.example.global.security.exception.InvalidTokenException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtParser {
    private final JwtProperties jwtProperties;
    private final CustomUserDetailService customUserDetailService;

    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);

        if (!claims.get("type").equals("access")) {
            throw InvalidTokenException.EXCEPTION;
        }

        UserDetails userDetails = getDetail(claims);

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public Claims getClaims(String token) {
        try {
            return Jwts.parser()
                .setSigningKey(jwtProperties.secret())
                .parseClaimsJws(token)
                .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    public String getHeader(HttpServletRequest req) {
        String token = req.getHeader(jwtProperties.header());

        if (StringUtils.hasText(token) && token.startsWith(jwtProperties.prefix()) && token.length() > 7) {
            token = token.split(" ")[1];
        }

        return token;
    }

    public UserDetails getDetail(Claims body) {
        String role = body.get("role").toString();

        if (List.of(Role.Head, Role.Student, Role.Teacher).contains(Role.valueOf(role))) {
            return customUserDetailService.loadUserByUserId(body.getSubject());
        } else {
            throw InvalidRoleException.EXCEPTION;
        }
    }
}
