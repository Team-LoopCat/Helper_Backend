package org.example.domain.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.User;
import org.example.domain.auth.service.SearchUser;
import org.example.domain.auth.spi.QueryAuthPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchUserImpl implements SearchUser {
    private final QueryAuthPort authPort;

    @Override
    public Optional<User> searchUserById(String userId) {
        return authPort.getUserById(userId);
    }
}
