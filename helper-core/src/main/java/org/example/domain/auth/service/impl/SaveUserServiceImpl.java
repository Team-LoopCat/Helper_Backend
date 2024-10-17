package org.example.domain.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.User;
import org.example.domain.auth.service.SaveUserService;
import org.example.domain.auth.spi.QueryAuthPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveUserServiceImpl implements SaveUserService {
    private final QueryAuthPort authPort;

    @Override
    public void saveUser(User user) {
        authPort.saveUser(user);
    }
}