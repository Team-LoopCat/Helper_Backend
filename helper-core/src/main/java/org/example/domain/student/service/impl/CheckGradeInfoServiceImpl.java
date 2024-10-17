package org.example.domain.student.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.student.exception.GradeInfoNotExistsException;
import org.example.domain.student.service.CheckGradeInfoService;
import org.example.domain.student.spi.QueryGradeInfoPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckGradeInfoServiceImpl implements CheckGradeInfoService {
    private final QueryGradeInfoPort gradeInfoPort;

    @Override
    public void checkGradeInfoExist(String grade, String classroom) {
        if (gradeInfoPort.checkGradeInfoExist(grade, classroom)) {
            throw GradeInfoNotExistsException.EXCEPTION;
        }
    }
}
