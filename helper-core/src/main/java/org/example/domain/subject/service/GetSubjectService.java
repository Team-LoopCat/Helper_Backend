package org.example.domain.subject.service;

import java.util.List;
import java.util.UUID;
import org.example.domain.subject.spi.vo.SubjectAndAttendVO;

public interface GetSubjectService {

    List<SubjectAndAttendVO> getSubjectsAndAttendsByTeacherId(UUID teacherId);
}
