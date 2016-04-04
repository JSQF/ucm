package io.saltcat.ucm.web.controller;

import io.saltcat.ucm.service.RoleService;
import io.saltcat.ucm.web.domain.AjaxResponse;
import io.saltcat.ucm.web.form.role.AddRoleForm;
import io.saltcat.ucm.web.form.role.UpdateRoleForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huawei on 4/3/16.
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Resource
    private RoleService roleService;

    @RequestMapping("/addRole")
    public void addRoleAction(HttpServletResponse response, AddRoleForm form) throws ServletException, IOException {
        AjaxResponse ajaxResponse = new AjaxResponse<>();
        try{
            form.validate();
            this.roleService.addRole(form.getName(), form.getCode());
            ajaxResponse.setCode(200);
        }catch (Exception e) {
            ajaxResponse.setCode(500);
            ajaxResponse.setMessage(e.getMessage());
            logger.error("保存失败:", e);
        }
        responseJson(response, ajaxResponse);
    }

    @RequestMapping("/updateRole")
    public void updateRoleAction(HttpServletResponse response, UpdateRoleForm form) throws ServletException, IOException {
        AjaxResponse ajaxResponse = new AjaxResponse<>();
        try{
            form.validate();
            this.roleService.updateRole(Integer.parseInt(form.getId()), form.getName());
            ajaxResponse.setCode(200);
        }catch (Exception e) {
            ajaxResponse.setCode(500);
            ajaxResponse.setMessage(e.getMessage());
            logger.error("更新失败:", e);
        }
        responseJson(response, ajaxResponse);
    }
}
