package com.goltsov.idea.platform.exception;

public class UnsupportedFileOrFormat extends RuntimeException {
    public UnsupportedFileOrFormat(String message) {
        super(message);
    }

    public UnsupportedFileOrFormat(Throwable cause) {
        super(cause);
    }
}
