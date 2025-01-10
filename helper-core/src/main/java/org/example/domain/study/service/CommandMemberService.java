package org.example.domain.study.service;

import org.example.domain.study.model.Member;

public interface CommandMemberService {

    Member saveMember(Member member);

    void deleteMember(Member member);
}
