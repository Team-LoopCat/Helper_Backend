package org.example.domain.study.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.student.model.Student;
import org.example.domain.study.exception.NotOwnStudyException;
import org.example.domain.study.model.Study;
import org.example.domain.study.service.CheckStudyService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckStudyServiceImpl implements CheckStudyService {

    @Override
    public void checkStudyIsOwn(Study study, Student student) {
        if (!study.getStudentId().equals(student.getStudentId())) throw NotOwnStudyException.EXCEPTION;
    }
}
