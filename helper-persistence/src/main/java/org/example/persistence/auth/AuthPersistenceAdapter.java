package org.example.persistence.auth;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.User;
import org.example.domain.auth.spi.QueryAuthPort;
import org.example.persistence.auth.mapper.UserMapper;
import org.example.persistence.auth.repository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthPersistenceAdapter implements QueryAuthPort {
    private final UserMapper userMapper;
    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> getUserById(String id) {
        return userMapper.toDomain(
                userJpaRepository.findByUserId(id)
        );
    }

    @Override
    public void saveUser(User user) {
        userJpaRepository.save(
                userMapper.toEntity(user)
        );
    }
}
