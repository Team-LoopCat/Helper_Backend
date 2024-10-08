package org.example.persistence.gradeInfo.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
public class GradeInfoId implements Serializable {
    private String grade;
    private String classroom;
}
