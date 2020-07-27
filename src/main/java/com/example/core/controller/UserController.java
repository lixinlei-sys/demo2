package com.example.core.controller;

import com.example.common.utils.ResultUtil;
import com.example.core.entity.SysMenu;
import com.example.core.service.SysMenuService;
import com.example.sercurity.entity.SelfUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 普通用户
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private SysMenuService  sysMenuService;

    /**
     * 用户端信息
     * @return
     */
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Map<String,Object> userLogin(){
        SelfUserEntity selfUserEntity= (SelfUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<String,Object> result=new HashMap<>();
        result.put("title","用户端信息");
        result.put("data",selfUserEntity);
        return ResultUtil.resultSuccess(result);
    }

    /**
     * 拥有 USER角色和 sys:user:info权限可以访问
     * @return
     */
    @PreAuthorize("hasRole('USER') and hasPermission('/user/menuList','sys:user:info')")
    @RequestMapping(value = "/menuList",method = RequestMethod.GET)
    public Map<String,Object> sysMenuList(){
        Map<String,Object> result=new HashMap<>();
        List<SysMenu> sysMenuList=sysMenuService.list();
        result.put("title","拥有USER角色和sys:user:info权限的可以访问");
        result.put("data",sysMenuList);
        return ResultUtil.resultSuccess(result);
    }
}
