package io.saltcat.ucm.service;

import io.saltcat.ucm.exception.UcmException;

/**
 * Created by huawei on 4/4/16.
 */
public interface UserService {

    void addUser(String username) throws UcmException;


}
