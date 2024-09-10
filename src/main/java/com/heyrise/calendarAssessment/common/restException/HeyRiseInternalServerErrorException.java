/*
 *  Author: DI Rainer Sickinger
 *  Date: 18.11.22, 17:21
 *  Contact: rainer.sickinger@heyrise.com
 *
 */

package com.heyrise.calendarAssessment.common.restException;

import org.springframework.http.HttpStatus;

public class HeyRiseInternalServerErrorException extends HeyRiseRestException{
    public HeyRiseInternalServerErrorException(Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, null, cause);
    }

    public HeyRiseInternalServerErrorException (final String msg) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, null, msg);
    }
}
