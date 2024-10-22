package org.example.persistence.study.entity;

import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class MemberId implements Serializable {

    private UUID studentId;

    private UUID studyId;
}
