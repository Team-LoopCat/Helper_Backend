package org.example.domain.study.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.study.exception.AlreadyJoinedStudyException;
import org.example.domain.study.exception.YouBannedFromStudyException;
import org.example.domain.study.model.Member;
import org.example.domain.study.service.CheckMemberService;
import org.example.domain.study.spi.QueryMemberPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckMemberServiceImpl implements CheckMemberService {
    private final QueryMemberPort queryMemberPort;

    @Override
    public void checkAlreadyJoined(Member member) {
        if (queryMemberPort.existsByStudyIdAndStudentId(member.getStudyId(), member.getStudentId())) {
            throw AlreadyJoinedStudyException.EXCEPTION;
        }
    }

    @Override
    public void checkBannedFromStudy(Member member) {
        if (member.getIsBanned()) {
            throw YouBannedFromStudyException.EXCEPTION;
        }
    }
}
