package org.example.persistence.subject.repository;

import java.util.UUID;
import org.example.persistence.subject.entity.AttendJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface AttendJpaRepository extends CrudRepository<AttendJpaEntity, UUID> {

}
