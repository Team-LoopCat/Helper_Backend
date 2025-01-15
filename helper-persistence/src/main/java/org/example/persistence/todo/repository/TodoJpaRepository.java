package org.example.persistence.todo.repository;

import java.util.UUID;
import org.example.persistence.todo.entity.TodoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJpaRepository extends JpaRepository<TodoJpaEntity, UUID> {

}
