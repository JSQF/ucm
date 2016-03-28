package io.saltcat.ucm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huawei on 3/20/16.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/show")
    public String showLogin(){
        return "login";
    }

}
