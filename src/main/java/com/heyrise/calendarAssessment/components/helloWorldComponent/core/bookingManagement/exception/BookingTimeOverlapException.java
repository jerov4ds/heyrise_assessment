package com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.exception;

import com.heyrise.calendarAssessment.common.restException.HeyRiseRestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BookingTimeOverlapException extends HeyRiseRestException {
    public BookingTimeOverlapException(final Throwable cause) {
        super(HttpStatus.BAD_REQUEST, null, cause);
    }

    public BookingTimeOverlapException(String msg, Object... args) {
        super(HttpStatus.BAD_REQUEST, null, String.format(msg, args));
    }
}
