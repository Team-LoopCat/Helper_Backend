package org.example.domain.exam.usecase;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.dto.request.StartExamRequestDto;
import org.example.domain.exam.dto.response.StartExamResponseDto;
import org.example.domain.exam.model.Exam;
import org.example.domain.exam.service.CheckExamService;
import org.example.domain.exam.service.CommandExamService;
import org.example.domain.teacher.model.Teacher;
import org.example.domain.teacher.service.GetTeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StartExamUseCase {
    private final CommandExamService commandExamService;
    private final GetTeacherService getTeacherService;
    private final CheckExamService checkExamService;

    public StartExamResponseDto execute(StartExamRequestDto request) {
        Teacher currentTeacher = getTeacherService.getCurrentTeacher();

        checkExamService.checkExamHasStartedByGrade(currentTeacher.getGrade().get());

        List<Exam> exams = request.exams().stream().map(exam ->
            commandExamService.startExam(
                    exam.major(),
                    currentTeacher.getGrade().get(),
                    exam.examData())
        ).toList();

        return StartExamResponseDto.from(exams);
    }
}
