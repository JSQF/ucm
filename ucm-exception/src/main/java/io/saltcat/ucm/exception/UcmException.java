package io.saltcat.ucm.exception;

/**
 * Created by huawei on 3/20/16.
 */
public class UcmException extends Exception {

    public UcmException() {
    }

    public UcmException(String message) {
        super(message);
    }

    public UcmException(String message, Throwable cause) {
        super(message, cause);
    }

    public UcmException(Throwable cause) {
        super(cause);
    }
}
