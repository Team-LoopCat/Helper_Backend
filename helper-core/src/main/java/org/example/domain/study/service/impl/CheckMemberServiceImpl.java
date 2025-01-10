package org.example.domain.study.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.student.model.Student;
import org.example.domain.study.exception.AlreadyJoinedStudyException;
import org.example.domain.study.exception.AlreadyBannedFromStudyException;
import org.example.domain.study.exception.MemberNotFoundException;
import org.example.domain.study.model.Study;
import org.example.domain.study.service.CheckMemberService;
import org.example.domain.study.spi.QueryMemberPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckMemberServiceImpl implements CheckMemberService {
    private final QueryMemberPort queryMemberPort;

    @Override
    public void checkJoinAvailable(Study study, Student student) {
        try {
            Boolean isBanned = queryMemberPort.findIsBannedByStudyIdAndStudentId(study.getStudyId(), student.getStudentId()).orElseThrow(
                    () -> MemberNotFoundException.EXCEPTION
            );

            if (isBanned) throw AlreadyBannedFromStudyException.EXCEPTION;
            else throw AlreadyJoinedStudyException.EXCEPTION;
        } catch (MemberNotFoundException e) {
            return;
        }
    }
}
