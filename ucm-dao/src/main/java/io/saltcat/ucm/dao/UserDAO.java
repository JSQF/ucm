package io.saltcat.ucm.dao;

import io.saltcat.ucm.domain.User;

/**
 * Created by huawei on 4/4/16.
 * User Service
 * 管理用户信息
 */
public interface UserDAO {

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);
}
