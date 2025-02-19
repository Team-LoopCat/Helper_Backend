package org.example.domain.subject.service;

import java.util.List;
import java.util.UUID;
import org.example.domain.subject.spi.vo.SubjectAndAttendVO;
import org.example.domain.subject.model.Subject;

public interface GetSubjectService {

    List<SubjectAndAttendVO> getSubjectsAndAttendsByTeacherId(UUID teacherId);

    Subject getSubjectById(UUID id);

    List<Subject> getSubjectsByTeacher(UUID teacherId);
}
