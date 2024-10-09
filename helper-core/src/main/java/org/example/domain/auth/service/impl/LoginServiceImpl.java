package org.example.domain.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.User;
import org.example.domain.auth.service.LoginService;
import org.example.domain.auth.spi.QueryAuthPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final QueryAuthPort queryAuthPort;

    @Override
    public Optional<User> getUserById(String id) {
        return queryAuthPort.getUserById(id);
    }
}
