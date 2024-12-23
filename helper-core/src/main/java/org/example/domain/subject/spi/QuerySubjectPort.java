package org.example.domain.subject.spi;

import org.example.domain.subject.model.Subject;

import java.util.Optional;
import java.util.UUID;

public interface QuerySubjectPort {

    Optional<Subject> getSubjectById(UUID subjectId);
}
