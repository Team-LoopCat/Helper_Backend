package org.example.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.Role;
import org.example.global.security.auth.StudentDetailService;
import org.example.global.security.auth.TeacherDetailService;
import org.example.global.security.exception.InvalidRoleException;
import org.example.global.security.exception.InvalidTokenException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class JwtParser {
    private final JwtProperties jwtProperties;
    private final StudentDetailService studentDetailService;
    private final TeacherDetailService teacherDetailService;

    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);

        if (claims.get("type") != "access") {
            throw InvalidTokenException.Exception;
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getHeader(HttpServletRequest req) {
        String token = req.getHeader(jwtProperties.header());

        if (StringUtils.hasText(token) && token.startsWith(jwtProperties.prefix()) && token.length() > 7) {
            token = token.split(" ")[0];
        }

        return token;
    }

    public UserDetails getDetail(Claims body) {
        String role = body.get("body").toString();

        if (Objects.equals(role, Role.Student.name())) {
            return studentDetailService.loadUserByUsername(body.getSubject());
        } else if (Objects.equals(role, Role.Head.name()) || Objects.equals(role, Role.Teacher.name())) {
            return teacherDetailService.loadUserByUsername(body.getSubject());
        } else {
            throw InvalidRoleException.Exception;
        }
    }
}
