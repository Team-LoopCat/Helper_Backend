package org.example.domain.test.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.test.exception.errorCode.TestErrorCode;

public class TestNotFoundException extends GlobalBusinessException {
    public static final TestNotFoundException EXCEPTION = new TestNotFoundException();

    public TestNotFoundException() { super(TestErrorCode.TEST_NOT_FOUND); }
}
