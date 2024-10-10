package org.example.persistence.student.repository;

import org.example.persistence.student.entity.StudentJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentJpaRepository extends CrudRepository<StudentJpaEntity, String> {

    Optional<StudentJpaEntity> findByStudentId(@Param("studentId") String studentId);
}
