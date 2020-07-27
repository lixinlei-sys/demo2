package com.example.core.controller;

import com.example.common.utils.ResultUtil;
import com.example.common.utils.SecurityUtil;
import com.example.core.entity.SysMenu;
import com.example.core.entity.SysRole;
import com.example.core.entity.SysUser;
import com.example.core.service.SysMenuService;
import com.example.core.service.SysRoleService;
import com.example.core.service.SysUserService;
import com.example.sercurity.entity.SelfUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理端
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 管理端信息
     * @return Map<String,Object> 返回数据Map
     */
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Map<String,Object> userLogin(){
        Map<String,Object> result=new HashMap<>();
        //获取当前用户信息
        SelfUserEntity selfUserEntity= SecurityUtil.getUserInfo();
        result.put("title","管理端信息");
        result.put("data",selfUserEntity);
        return ResultUtil.resultSuccess(result);
    }

    /**
     * 拥有ADMIN或者USER的角色可以访问
     * @return
     */
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map<String,Object> list(){
        Map<String,Object> result = new HashMap<>();
        List<SysUser> sysUsers = sysUserService.list();
        result.put("title","拥有用户或者管理员角色都可以查看");
        result.put("data",sysUsers);
        return ResultUtil.resultSuccess(result);
    }

    /**
     * 拥有 ADMIN和 USER角色可以访问
     * @return
     */
    @PreAuthorize("hasRole('ADMIN') and hasRole('USER')")
    @RequestMapping(value = "/menuList",method = RequestMethod.GET)
    public Map<String,Object> menuList(){
        Map<String,Object> result=new HashMap<>();
        List<SysMenu> sysMenuList=sysMenuService.list();
        result.put("title","拥有用户和管理员角色都可以查看");
        result.put("data",sysMenuList);
        return ResultUtil.resultSuccess(result);
    }

    /**
     * 拥有 sys:user:info权限的人可以访问
     * hasPermission 第一个参数是请求路径，第二个是权限表达式
     * @return
     */
    @PreAuthorize("hasPermission('/admin/userList','sys:user:info')")
    @RequestMapping(value = "/userList",method = RequestMethod.GET)
    public Map<String,Object> userList(){
        Map<String,Object> result=new HashMap<>();
        List<SysUser> sysUsersList=sysUserService.list();
        result.put("title","拥有sys:user:info权限都可以查看");
        result.put("data",sysUsersList);
        return ResultUtil.resultSuccess(result);
    }

    /**
     * 拥有 ADMIN和 sys:role:info 权限可以访问
     * @return
     */
    @PreAuthorize("hasRole('ADMIN') and hasPermission('/admin/adminRoleList','sys:role:info')")
    @RequestMapping(value = "/adminRoleList",method = RequestMethod.GET)
    public Map<String,Object> adminRoleList(){
        Map<String,Object> result=new HashMap<>();
        List<SysRole> sysRoleList=sysRoleService.list();
        result.put("title","用于ADMIN角色和sys:role:info权限可以访问");
        result.put("data",sysRoleList);
        return ResultUtil.resultSuccess(result);
    }
    
    
}
