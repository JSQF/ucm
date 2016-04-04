package io.saltcat.ucm.web.form;

import io.saltcat.ucm.exception.UcmException;

/**
 * Created by huawei on 4/3/16.
 */
public interface ValidForm {

    void validate() throws UcmException;
}
