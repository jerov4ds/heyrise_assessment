/*
 *  Author: DI Rainer Sickinger
 *  Date: 18.11.22, 17:21
 *  Contact: rainer.sickinger@heyrise.com
 *
 */

package com.heyrise.calendarAssessment.common.restException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HeyRiseResourceNotFoundException extends HeyRiseRestException {
    public HeyRiseResourceNotFoundException(final Throwable cause) {
        super(HttpStatus.NOT_FOUND, null, cause);
    }

    public HeyRiseResourceNotFoundException(String msg, Object... args) {
        super(HttpStatus.NOT_FOUND, null, String.format(msg, args));
    }
}
