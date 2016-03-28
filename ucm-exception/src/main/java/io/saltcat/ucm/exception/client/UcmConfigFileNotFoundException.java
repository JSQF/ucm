package io.saltcat.ucm.exception.client;

import io.saltcat.ucm.exception.UcmException;

/**
 * Created by huawei on 3/20/16.
 */
public class UcmConfigFileNotFoundException extends UcmConfigException {

    public UcmConfigFileNotFoundException() {
    }

    public UcmConfigFileNotFoundException(String message) {
        super(message);
    }

    public UcmConfigFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UcmConfigFileNotFoundException(Throwable cause) {
        super(cause);
    }
}
