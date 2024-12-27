package org.example.domain.subject.service;

import org.example.domain.subject.model.Subject;

import java.util.UUID;

public interface GetSubjectService {

    Subject getSubjectById(UUID id);
}
