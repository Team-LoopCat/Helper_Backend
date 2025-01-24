package org.example.domain.exam.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.exam.service.CommandExamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteExamUseCase {
    private final CommandExamService commandExamService;

    public void execute() {
        commandExamService.deleteAllExams();
    }
}
