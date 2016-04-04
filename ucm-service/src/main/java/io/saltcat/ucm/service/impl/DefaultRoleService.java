package io.saltcat.ucm.service.impl;

import io.saltcat.ucm.dao.RoleDAO;
import io.saltcat.ucm.domain.Role;
import io.saltcat.ucm.exception.UcmException;
import io.saltcat.ucm.exception.web.RoleExistsException;
import io.saltcat.ucm.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * Created by huawei on 4/3/16.
 */
public class DefaultRoleService implements RoleService {

    private static Logger logger = LoggerFactory.getLogger(DefaultRoleService.class);

    private RoleDAO roleDAO;

    @Override
    public void addRole(String name, String code) throws UcmException{
        if (isRoleExists(code)) {
            throw new RoleExistsException(code + "已经存在");
        }
        Role role = new Role();
        role.setCode(code);
        role.setName(name);
        try{
            this.roleDAO.addRole(role);
        }catch (Exception e) {
            throw new UcmException("保存角色异常", e);
        }
    }

    @Override
    public boolean isRoleExists(String code) throws UcmException{
        if(!StringUtils.hasLength(code)) {
            throw new UcmException("角色代码不能为空");
        }
        try{
           return this.roleDAO.getRole(code) != null;
        }catch (Exception e) {
            logger.error("查询失败", e);
            throw new UcmException("查询角色信息失败:", e);
        }
    }

    @Override
    public void updateRole(Integer id, String name) throws UcmException {
        if (id == null) {
            throw new UcmException("角色ID不能为null");
        }

        if (!StringUtils.hasLength(name)) {
            throw new UcmException("名称不能为空");
        }



    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
}
