package com.heyrise.calendarAssessment.common.exception;

public abstract class HeyRiseBaseException extends Exception{
    public HeyRiseBaseException(String msg) {
        super(msg);
    }

    public HeyRiseBaseException(String msg, Object... args) {
        super(String.format(msg, args));
    }

    public HeyRiseBaseException(Exception cause) {
        super(cause);
    }
}
