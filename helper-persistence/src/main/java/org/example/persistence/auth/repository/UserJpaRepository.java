package org.example.persistence.auth.repository;

import java.util.Optional;

import org.example.domain.auth.model.User;
import org.example.persistence.auth.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserJpaRepository extends CrudRepository<UserJpaEntity, String> {

    Optional<UserJpaEntity> findByUserId(String userId);

    Boolean existsByUserId(String userId);

    void deleteByUserId(String userId);

    @Query("SELECT new org.example.domain.auth.model.User(u.userId, u.password, u.role, u.profile) " +
            "FROM student s INNER JOIN user u ON s.user.userId = u.userId " +
            "WHERE s.studentId = :studentId")
    User findByStudentId(@Param("studentId") String studentId);
}
