package org.example.persistence.student.repository;

import java.util.Optional;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentJpaRepository extends CrudRepository<StudentJpaEntity, String> {

    Optional<StudentJpaEntity> findByStudentId(String studentId);

    Boolean existsByStudentId(String studentNum);

    Boolean existsByEmail(String email);
}
