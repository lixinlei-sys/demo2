package com.example.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class loginController {
    
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    
    
    
    /*@PostMapping("/")
    public String login(HttpServletRequest req)  {
        String fail= (String) req.getAttribute("shiroLoginFailure");
        List<String> list= Arrays.asList(Exception.class.getName());
        String loginErr="其他错误!";
        if(list.contains(fail)){
            loginErr="用户名或密码错误!!!";
            req.setAttribute("loginErr",loginErr);
            return "login";
        }
        return "index";
        
    }*/
}
