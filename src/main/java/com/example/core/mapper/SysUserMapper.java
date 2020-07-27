package com.example.core.mapper;

import com.example.core.entity.SysMenu;
import com.example.core.entity.SysRole;
import com.example.core.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author li
 * @since 2020-07-21
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 通过用户id查询角色集合
     * @param id
     * @return
     */
    List<SysRole> selectSysRoleByUserId(Integer id);

    /**
     * 通过用户id查询权限集合
     * @param id
     * @return
     */
    List<SysMenu> selectSysMenuByUserId(Integer id);

}
