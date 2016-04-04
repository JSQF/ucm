package io.saltcat.ucm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huawei on 4/3/16.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @RequestMapping("/addUserRole")
    public void addUserRoleAction(HttpServletResponse response) throws ServletException, IOException {

    }

    @RequestMapping("/addUserProject")
    public void addUserProject(HttpServletResponse response) throws ServletException, IOException {

    }
}
