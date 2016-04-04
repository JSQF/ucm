package io.saltcat.ucm.exception.web;

import io.saltcat.ucm.exception.UcmException;

/**
 * Created by huawei on 4/3/16.
 */
public class RoleExistsException extends UcmException {

    public RoleExistsException() {
    }

    public RoleExistsException(String message) {
        super(message);
    }

    public RoleExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoleExistsException(Throwable cause) {
        super(cause);
    }
}
