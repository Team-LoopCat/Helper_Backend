package org.example.domain.subject.spi;

import java.util.UUID;

public interface QueryAttendPort {

    boolean checkAttendExistsByAttendId(UUID attendId);
}
