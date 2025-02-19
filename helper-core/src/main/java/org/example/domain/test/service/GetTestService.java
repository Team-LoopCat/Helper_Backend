package org.example.domain.test.service;

import org.example.domain.test.model.Test;

import java.util.UUID;

public interface GetTestService {

    Test getTestById(UUID testId);
}
