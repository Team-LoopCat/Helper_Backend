package org.example.domain.teacher.model;

import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class Teach implements Serializable {

    private UUID teacherId;

    private UUID subjectId;
}
