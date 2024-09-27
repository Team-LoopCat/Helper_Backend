package org.example.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.Role;
import org.example.domain.student.model.Student;
import org.example.domain.student.spi.QueryStudentPort;
import org.example.global.security.exception.ForbiddenRoleException;
import org.example.global.security.exception.InvalidRoleException;
import org.example.global.security.exception.InvalidTokenException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentDetailService implements UserDetailsService {
    private final QueryStudentPort queryStudentPort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = queryStudentPort.queryUserById(username).orElseThrow(() -> InvalidTokenException.Exception);
        if (student.getRole() != Role.Student) throw InvalidRoleException.Exception;

        return new StudentDetail(
                student.getUserId(),
                student.getRole()
        );
    }
}
