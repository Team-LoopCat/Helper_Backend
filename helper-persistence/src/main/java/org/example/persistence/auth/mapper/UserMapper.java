package org.example.persistence.auth.mapper;

import org.example.domain.auth.model.User;
import org.example.persistence.GenericMapper;
import org.example.persistence.auth.entity.UserJpaEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserMapper implements GenericMapper<User, UserJpaEntity> {
    @Override
    public Optional<User> toDomain(UserJpaEntity entity) {
        if (entity == null) return Optional.empty();

        return Optional.of(new User(
                entity.getUserId(),
                entity.getPassword(),
                entity.getRole(),
                entity.getProfile())
        );
    }

    @Override
    public UserJpaEntity toEntity(User entity) {
        return new UserJpaEntity(
                entity.getUserId(),
                entity.getPassword(),
                entity.getRole(),
                entity.getProfile()
        );
    }
}
