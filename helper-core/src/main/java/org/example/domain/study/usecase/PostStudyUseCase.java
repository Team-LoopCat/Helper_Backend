package org.example.domain.study.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.auth.model.User;
import org.example.domain.study.dto.request.PostStudyRequestDto;
import org.example.domain.study.dto.response.PostStudyResponseDto;
import org.example.domain.study.model.Study;
import org.example.domain.study.service.CommandStudyService;
import org.example.domain.subject.model.Subject;
import org.example.domain.subject.service.GetSubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostStudyUseCase {
    private final GetSubjectService getSubjectService;
    private final CommandStudyService commandStudyService;
    private final SecurityService securityService;

    public PostStudyResponseDto execute(PostStudyRequestDto request) {
        User user = securityService.getCurrentUser();
        Subject subject = getSubjectService.getSubjectById(request.subjectId());

        Study study = commandStudyService.saveStudy(
                Study.builder()
                        .studentId(user.getUserId())
                        .subjectId(subject.getSubjectId())
                        .title(request.title())
                        .content(request.content())
                        .location(request.location())
                        .date(request.date())
                        .start(request.start())
                        .end(request.end())
                        .category(request.category())
                        .build()
        );

        return new PostStudyResponseDto(study.getStudyId());
    }
}
