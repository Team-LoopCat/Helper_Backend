package org.example.persistence.student.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class GradeInfoId implements Serializable {

    private String grade;

    private String classroom;
}
