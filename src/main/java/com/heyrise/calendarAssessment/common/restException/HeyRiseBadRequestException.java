package com.heyrise.calendarAssessment.common.restException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class HeyRiseBadRequestException extends HeyRiseRestException{
    public HeyRiseBadRequestException (final Throwable cause) {
        super(HttpStatus.BAD_REQUEST, null, cause);
    }

    public HeyRiseBadRequestException(String msg) {
        super(HttpStatus.BAD_REQUEST, null, msg);
    }

    public HeyRiseBadRequestException(String msg, Object... args) {
        super(HttpStatus.BAD_REQUEST, null, String.format(msg, args));
    }
}
