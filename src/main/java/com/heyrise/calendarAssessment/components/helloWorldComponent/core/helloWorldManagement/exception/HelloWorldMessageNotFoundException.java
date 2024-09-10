package com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.exception;

import com.heyrise.calendarAssessment.common.exception.HeyRiseBaseException;

public class HelloWorldMessageNotFoundException extends HeyRiseBaseException {
    public HelloWorldMessageNotFoundException(final String msg) {
        super(msg);
    }

    public HelloWorldMessageNotFoundException(
            final String msg,
            final Object... args
    ) {
        super(
                msg,
                args
        );
    }

    public HelloWorldMessageNotFoundException(final Exception cause) {
        super(cause);
    }
}
