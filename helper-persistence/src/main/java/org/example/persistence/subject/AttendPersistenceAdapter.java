package org.example.persistence.subject;

import lombok.RequiredArgsConstructor;
import org.example.domain.subject.model.Attend;
import org.example.domain.subject.spi.QueryAttendPort;
import org.example.persistence.subject.repository.AttendJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AttendPersistenceAdapter implements QueryAttendPort {
    private final AttendJpaRepository attendJpaRepository;

    @Override
    public boolean checkAttendExistsByAttendId(UUID attendId) {
        return attendJpaRepository.existsByAttendId(attendId);
    }

    @Override
    public List<Attend> getAttendsByTest(UUID testId) {
        return attendJpaRepository.getAttendsByTestId(testId);
    }
}
