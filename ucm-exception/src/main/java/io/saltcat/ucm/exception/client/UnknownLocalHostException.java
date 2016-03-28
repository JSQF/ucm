package io.saltcat.ucm.exception.client;

import io.saltcat.ucm.exception.UcmException;

/**
 * Created by huawei on 3/20/16.
 */
public class UnknownLocalHostException extends UcmException {

    public UnknownLocalHostException() {
    }

    public UnknownLocalHostException(String message) {
        super(message);
    }

    public UnknownLocalHostException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownLocalHostException(Throwable cause) {
        super(cause);
    }
}
