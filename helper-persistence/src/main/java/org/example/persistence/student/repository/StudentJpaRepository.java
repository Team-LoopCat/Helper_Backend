package org.example.persistence.student.repository;

import java.util.Optional;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentJpaRepository extends CrudRepository<StudentJpaEntity, String> {

    Optional<StudentJpaEntity> findByStudentId(@Param("studentId") String studentId);
}
