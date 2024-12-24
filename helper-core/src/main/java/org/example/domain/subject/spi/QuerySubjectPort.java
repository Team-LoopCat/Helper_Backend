package org.example.domain.subject.spi;

import java.util.List;
import java.util.UUID;
import org.example.domain.subject.spi.vo.SubjectAndAttendVO;

public interface QuerySubjectPort {

    List<SubjectAndAttendVO> getSubjectsAndAttendsByTeacherId(UUID teacherId);
}
