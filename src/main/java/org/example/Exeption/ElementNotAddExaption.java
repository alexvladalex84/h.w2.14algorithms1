package org.example.Exeption;

public class ElementNotAddExaption extends RuntimeException {
    public ElementNotAddExaption() {
    }

    public ElementNotAddExaption(String message) {
        super(message);
    }

    public ElementNotAddExaption(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementNotAddExaption(Throwable cause) {
        super(cause);
    }

    public ElementNotAddExaption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
