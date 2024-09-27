package org.example.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.Role;
import org.example.domain.teacher.model.Teacher;
import org.example.domain.teacher.spi.QueryTeacherPort;
import org.example.global.security.exception.InvalidRoleException;
import org.example.global.security.exception.InvalidTokenException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeacherDetailService implements UserDetailsService {
    private final QueryTeacherPort queryTeacherPort;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Teacher teacher = queryTeacherPort.queryUserById(UUID.fromString(username)).orElseThrow(() -> InvalidTokenException.Exception);
        if (teacher.getRole() != Role.Teacher && teacher.getRole() != Role.Head) throw InvalidRoleException.Exception;

        return new TeacherDetail(
                teacher.getUserId(),
                teacher.getRole()
        );
    }
}
