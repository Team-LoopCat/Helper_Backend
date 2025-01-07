package org.example.domain.study.service;

import org.example.domain.study.model.Member;

public interface CheckMemberService {

    void checkAlreadyJoined(Member member);

    void checkBannedFromStudy(Member member);
}
