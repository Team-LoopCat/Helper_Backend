package org.example.common.spi;

import org.springframework.stereotype.Component;

@Component
public interface SecurityPort {

    String getCurrentUserId();
}
