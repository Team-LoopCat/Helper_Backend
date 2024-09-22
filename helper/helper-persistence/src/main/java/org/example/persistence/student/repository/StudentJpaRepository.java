package org.example.persistence.student.repository;

import org.example.persistence.student.entity.StudentJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentJpaRepository extends CrudRepository<StudentJpaEntity, String> {
    @Query(value = "select * from student where studentId=:studentId", nativeQuery = true)
    Optional<StudentJpaEntity> findByStudentId(@Param("studentId") String studentId);
}
