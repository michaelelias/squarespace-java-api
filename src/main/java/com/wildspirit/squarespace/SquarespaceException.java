package com.wildspirit.squarespace;

public final class SquarespaceException extends RuntimeException {
    public SquarespaceException(String message) {
        super(message);
    }

    public SquarespaceException(String message, Throwable cause) {
        super(message, cause);
    }
}
