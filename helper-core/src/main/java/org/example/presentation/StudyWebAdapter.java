package org.example.presentation;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.study.dto.response.GetStudyDetailResponseDto;
import org.example.domain.study.dto.response.GetStudyListResponseDto;
import org.example.domain.study.dto.request.PostStudyRequestDto;
import org.example.domain.study.dto.request.UpdateStudyRequestDto;
import org.example.domain.study.dto.response.PostStudyResponseDto;
import org.example.domain.study.model.Category;
import org.example.domain.study.usecase.DeleteStudyUseCase;
import org.example.domain.study.usecase.GetMyStudyListUseCase;
import org.example.domain.study.usecase.GetStudyDetailUseCase;
import org.example.domain.study.usecase.GetStudyListUseCase;
import org.example.domain.study.usecase.JoinStudyUseCase;
import org.example.domain.study.usecase.LeaveStudyUseCase;
import org.example.domain.study.usecase.PostStudyUseCase;
import org.example.domain.study.usecase.StudyBanStudentUseCase;
import org.example.domain.study.usecase.UpdateStudyUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/study")
public class StudyWebAdapter {
    private final PostStudyUseCase postStudyUseCase;
    private final UpdateStudyUseCase updateStudyUseCase;
    private final DeleteStudyUseCase deleteStudyUseCase;
    private final JoinStudyUseCase joinStudyUseCase;
    private final LeaveStudyUseCase leaveStudyUseCase;
    private final StudyBanStudentUseCase studyBanStudentUseCase;
    private final GetStudyListUseCase getStudyListUseCase;
    private final GetStudyDetailUseCase getStudyDetailUseCase;
    private final GetMyStudyListUseCase getMyStudyListUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PostStudyResponseDto postStudy(@RequestBody PostStudyRequestDto postStudyRequest) {
        return postStudyUseCase.execute(postStudyRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{study_id}")
    public void updateStudy(@PathVariable("study_id") UUID studyId, @RequestBody UpdateStudyRequestDto updateStudyRequest) {
        updateStudyUseCase.execute(studyId, updateStudyRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{study_id}")
    public void deleteStudy(@PathVariable("study_id") UUID studyId) {
        deleteStudyUseCase.execute(studyId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/join/{study_id}")
    public void joinStudy(@PathVariable("study_id") UUID studyId) {
        joinStudyUseCase.execute(studyId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/leave/{study_id}")
    public void leaveStudy(@PathVariable("study_id") UUID studyId) {
        leaveStudyUseCase.execute(studyId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/ban/{study_id}/{student_id}")
    public void banStudent(@PathVariable("study_id") UUID studyId, @PathVariable("student_id") String student_id) {
        studyBanStudentUseCase.execute(studyId, student_id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public GetStudyListResponseDto getStudyList(@RequestParam(value = "category", required = false) Category category) {
        return getStudyListUseCase.execute(category);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{study_id}")
    public GetStudyDetailResponseDto getStudyDetail(@PathVariable("study_id") UUID studyId) {
        return getStudyDetailUseCase.execute(studyId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/my")
    public GetStudyListResponseDto getMyStudyList() {
        return getMyStudyListUseCase.execute();
    }
}
