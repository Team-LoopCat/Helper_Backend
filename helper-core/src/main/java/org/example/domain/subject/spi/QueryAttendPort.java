package org.example.domain.subject.spi;

import org.example.domain.subject.model.Attend;
import org.example.domain.test.model.Test;

import java.util.List;
import java.util.UUID;

public interface QueryAttendPort {

    boolean checkAttendExistsByAttendId(UUID attendId);

    List<Attend> getAttendsByTest(UUID testId);
}
