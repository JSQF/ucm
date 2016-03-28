package io.saltcat.ucm.exception.client;

import io.saltcat.ucm.exception.UcmException;

/**
 * Created by huawei on 3/20/16.
 */
public class UcmConfigException extends UcmException {

    public UcmConfigException() {
    }

    public UcmConfigException(String message) {
        super(message);
    }

    public UcmConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public UcmConfigException(Throwable cause) {
        super(cause);
    }
}
