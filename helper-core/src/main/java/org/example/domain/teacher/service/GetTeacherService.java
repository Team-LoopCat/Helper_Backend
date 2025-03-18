package org.example.domain.teacher.service;

import org.example.domain.teacher.model.Teacher;

import java.util.List;
import java.util.UUID;

public interface GetTeacherService {

    Teacher getCurrentTeacher();

    Teacher getTeacherByUserId(String id);

    List<String> getTeacherNamesBySubjectId(UUID subjectId);
}
