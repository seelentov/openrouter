package ru.vladislavkomkov.openrouter.exception;

public class AIRequestException extends Exception {
    public AIRequestException() {
    }

    public AIRequestException(String message) {
        super(message);
    }

    public AIRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public AIRequestException(Throwable cause) {
        super(cause);
    }

    protected AIRequestException(String message, Throwable cause,
                                 boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
