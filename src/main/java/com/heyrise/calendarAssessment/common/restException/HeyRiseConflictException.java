package com.heyrise.calendarAssessment.common.restException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class HeyRiseConflictException extends HeyRiseRestException{
    public HeyRiseConflictException(final String errorCode, final Throwable cause) {
        super(HttpStatus.CONFLICT, errorCode, cause);
    }

    public HeyRiseConflictException(String msg, String errorCode, Object... args) {
        super(HttpStatus.CONFLICT, errorCode, String.format(msg, args));
    }
}
