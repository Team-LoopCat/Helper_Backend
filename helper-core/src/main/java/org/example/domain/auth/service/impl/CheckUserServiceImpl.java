package org.example.domain.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.exception.UserNotFoundException;
import org.example.domain.auth.service.CheckUserService;
import org.example.domain.auth.spi.QueryAuthPort;
import org.example.domain.student.exception.UserIdAlreadyExistsException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckUserServiceImpl implements CheckUserService {
    private final QueryAuthPort authPort;

    @Override
    public void checkUserExistsById(String id) {
        if (authPort.checkUserById(id)) {
            throw UserIdAlreadyExistsException.EXCEPTION;
        }
    }
}
