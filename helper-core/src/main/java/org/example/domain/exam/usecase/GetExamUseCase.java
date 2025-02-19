package org.example.domain.exam.usecase;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.dto.response.GetExamListResponseDto;
import org.example.domain.exam.model.Exam;
import org.example.domain.exam.service.GetExamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GetExamUseCase {
    private final GetExamService getExamService;

    public GetExamListResponseDto execute() {
        List<Exam> exams = getExamService.getExamList();

        return GetExamListResponseDto.from(exams);
    }
}
