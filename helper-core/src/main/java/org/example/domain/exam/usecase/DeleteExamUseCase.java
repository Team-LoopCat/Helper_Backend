package org.example.domain.exam.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.exam.service.CheckExamService;
import org.example.domain.exam.service.CommandExamService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteExamUseCase {
    private final CommandExamService commandExamService;
    private final CheckExamService checkExamService;

    @Scheduled(cron = "0 0 0 * * *")
    public void execute() {
        if (checkExamService.checkExamWasFinished()) {
            commandExamService.deleteAllExams();
        }
    }
}
