package org.example.domain.study.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.student.model.Student;
import org.example.domain.study.exception.MemberNotFoundException;
import org.example.domain.study.model.Member;
import org.example.domain.study.model.Study;
import org.example.domain.study.service.GetMemberService;
import org.example.domain.study.spi.QueryMemberPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMemberServiceImpl implements GetMemberService {
    private final QueryMemberPort queryMemberPort;

    @Override
    public Member getByStudyAndStudent(Study study, Student student) {
        return queryMemberPort.findByStudyIdAbdStudentId(study.getStudyId(), student.getStudentId()).orElseThrow(
                () -> MemberNotFoundException.EXCEPTION
        );
    }
}
