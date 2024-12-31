package org.example.domain.study.service;

import org.example.domain.auth.model.User;
import org.example.domain.study.model.Study;

public interface CheckStudyService {

    void checkStudyIsOwn(Study study, User user);
}
