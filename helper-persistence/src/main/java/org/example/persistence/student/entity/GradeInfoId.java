package org.example.persistence.student.entity;

import lombok.AccessLevel;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GradeInfoId implements Serializable {

    private String grade;

    private String classroom;
}
