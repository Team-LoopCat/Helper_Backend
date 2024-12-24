package org.example.domain.subject.service.impl;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

import org.example.domain.subject.service.GetSubjectService;
import org.example.domain.subject.spi.QuerySubjectPort;
import org.example.domain.subject.spi.vo.SubjectAndAttendVO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSubjectServiceImpl implements GetSubjectService {
    private final QuerySubjectPort querySubjectPort;
    
    @Override
    public List<SubjectAndAttendVO> getSubjectsAndAttendsByTeacherId(UUID teacherId) {
        return querySubjectPort.getSubjectsAndAttendsByTeacherId(teacherId);
    }
}
