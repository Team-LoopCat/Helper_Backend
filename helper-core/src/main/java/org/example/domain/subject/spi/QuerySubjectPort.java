package org.example.domain.subject.spi;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

import org.example.domain.subject.model.Subject;
import org.example.domain.subject.spi.vo.SubjectAndAttendVO;
import org.example.domain.teacher.model.Teacher;

public interface QuerySubjectPort {

    List<SubjectAndAttendVO> getSubjectsAndAttendsByTeacherId(UUID teacherId);

    Optional<Subject> getSubjectById(UUID subjectId);

    List<Subject> getSubjectsByTeacher(UUID teacherId);
}
