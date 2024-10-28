package org.example.persistence.student;

import lombok.RequiredArgsConstructor;
import org.example.domain.student.spi.QueryGradeInfoPort;
import org.example.persistence.gradeInfo.repository.GradeInfoJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GradeInfoPersistenceAdapter implements QueryGradeInfoPort {
    private final GradeInfoJpaRepository gradeInfoRepository;

    @Override
    public Boolean checkGradeInfoExist(String grade, String classroom) {
        return gradeInfoRepository.existsByGradeAndClassroom(grade, classroom);
    }
}
