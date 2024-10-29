package org.example.persistence.test.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.example.persistence.subject.entity.AttendJpaEntity;

@EqualsAndHashCode
@AllArgsConstructor
public class TestInfoId implements Serializable {

    private AttendJpaEntity attend;

    private TestJpaEntity test;
}
