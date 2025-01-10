package org.example.domain.study.service;

import java.util.List;
import java.util.UUID;
import org.example.domain.student.model.Student;
import org.example.domain.study.model.Category;
import org.example.domain.study.model.Study;
import org.example.domain.study.spi.vo.StudyWithMemberCountVO;
import org.example.domain.subject.model.Subject;

public interface GetStudyService {

    Study getStudyById(UUID studyId);

    StudyWithMemberCountVO getStudyDetailById(UUID studyId);

    List<StudyWithMemberCountVO> getStudyListByStudent(Student student);

    List<StudyWithMemberCountVO> getAllStudyList();

    List<StudyWithMemberCountVO> getStudyListByCategory(Category category);
}
