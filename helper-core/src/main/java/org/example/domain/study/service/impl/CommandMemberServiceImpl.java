package org.example.domain.study.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.study.model.Member;
import org.example.domain.study.service.CommandMemberService;
import org.example.domain.study.spi.QueryMemberPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandMemberServiceImpl implements CommandMemberService {
    private final QueryMemberPort queryMemberPort;

    @Override
    public Member saveMember(Member member) {
        return queryMemberPort.saveMember(member);
    }

    @Override
    public void deleteMember(Member member) {
        queryMemberPort.deleteMember(member);
    }
}
