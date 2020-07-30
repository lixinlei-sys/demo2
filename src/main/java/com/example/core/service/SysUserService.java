package com.example.core.service;

import com.example.core.entity.SysMenu;
import com.example.core.entity.SysRole;
import com.example.core.entity.SysRoleMenu;
import com.example.core.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统用户业务接口
 * </p>
 *
 * @author li
 * @since 2020-07-21
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据用户名查询实体
     * @param name
     * @return
     */
    SysUser selectUserByName (String name);

    /**
     * 根据用户Id查询角色集合
     * @param id
     * @return
     */
    List<SysRole> selectSysRoleByUserId(Long id);

    /**
     * 根据用户id查询权限集合
     * @param id
     * @return
     */
    List<SysMenu> selectSysMenuByUserId(Long id);
}
