package org.example.domain.study.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.User;
import org.example.domain.study.exception.NotOwnStudyException;
import org.example.domain.study.model.Study;
import org.example.domain.study.service.CheckStudyService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckStudyServiceImpl implements CheckStudyService {

    @Override
    public void checkStudyIsOwn(Study study, User user) {
        if (!study.getStudentId().equals(user.getUserId())) throw NotOwnStudyException.EXCEPTION;
    }
}
