package io.saltcat.ucm.dao;

import io.saltcat.ucm.domain.Role;
import io.saltcat.ucm.domain.dao.RoleCondition;

import java.util.List;

/**
 * Created by huawei on 4/3/16.
 */
public interface RoleDAO {

    /**
     * 根据用户名查询所有角色
     * @param username 用户名
     * @return 该用户的角色列表
     */
    List<Role> getRoles(String username);

    /**
     * 添加角色
     * @param role 角色信息
     */
    void addRole(Role role);

    /**
     * 更新角色
     * @param roleId 角色ID
     * @param role 角色信息
     */
    void updateRole(Integer roleId, Role role);

    /**
     * 删除角色
     * @param id 角色ID
     */
    void remoteRole(Integer id);

    /**
     * 统计角色数量
     * @return 角色数量
     */
    int count();

    /**
     * 分页查询角色信息
     * @param condition 查询角色条件
     * @param start 起始页
     * @param length 每页条数
     * @return 角色列表
     */
    List<Role> getRoles(RoleCondition condition, int start, int length);

    /**
     * 条件查询角色的数量
     * @param condition 查询角色条件
     * @return 角色数量
     */
    int count(RoleCondition condition);

    /**
     * 根据角色代码获取角色信息
     * @param code 角色代码
     * @return 角色信息
     */
    Role getRole(String code);

    /**
     * 根据ID查询角色信息
     * @param id
     * @return
     */
    Role getRole(Integer id);



}
