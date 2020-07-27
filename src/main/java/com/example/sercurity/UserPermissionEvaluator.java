package com.example.sercurity;

import com.example.core.entity.SysMenu;
import com.example.core.service.SysUserService;
import com.example.sercurity.entity.SelfUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义权限注解
 */
@Component
public class UserPermissionEvaluator implements PermissionEvaluator {
    
    @Autowired
    private SysUserService sysUserService;

    /**
     * hasPermission 鉴权方法
     * 这里仅仅判断PreAuthorize注解中的权限表达式
     * 实际中可以根据业务需求设计数据库通过 targetUrl 和 permission 做更复杂的鉴权
     * 当然 targetUrl 不一定就是 url 可以是数据 id 还可以是管理员表示，这里根据需求自行设计
     * @param authentication 用户身份（在使用 hasPermission 表达式时 authentication参数默认会自动带上）
     * @param targetUrl 请求路径
     * @param permission 请求路径的权限
     * @return boolean 是否通过
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object permission) {
        // 获取用户信息
        SelfUserEntity selfUserEntity= (SelfUserEntity) authentication.getPrincipal();
        // 查询用户权限（这里可以将权限写入缓存中提高效率）
        Set<String> permissions=new HashSet<>();
        List<SysMenu> sysMenuList=sysUserService.selectSysMenuByUserId(selfUserEntity.getUserId());
        for (SysMenu sysMenu : sysMenuList){
            permissions.add(sysMenu.getPermission());
        }
        // 权限对比
        if (permissions.contains(permission.toString())){
            return true;
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
