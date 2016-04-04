package io.saltcat.ucm.service;

import io.saltcat.ucm.exception.UcmException;

/**
 * Created by huawei on 4/3/16.
 */
public interface RoleService {

    void addRole(String name, String code) throws UcmException;

    boolean isRoleExists(String code) throws UcmException;

    void updateRole(Integer id, String name) throws UcmException;
}
