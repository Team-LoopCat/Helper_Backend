package org.example.persistence.student.repository;

import org.example.persistence.student.entity.StudentJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentJpaRepository extends CrudRepository<StudentJpaEntity, String> {

    Optional<StudentJpaEntity> findByStudentId(String studentId);

    Optional<StudentJpaEntity> findByEmail(String email);
}
