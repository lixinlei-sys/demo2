package com.example.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.core.entity.SysMenu;
import com.example.core.entity.SysRole;
import com.example.core.entity.SysUser;
import com.example.core.mapper.SysUserMapper;
import com.example.core.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统用户业务实现
 * </p>
 *
 * @author li
 * @since 2020-07-21
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    /**
     * 根据用户名查询实体
     * @param name
     * @return
     */
    @Override
    public SysUser selectUserByName(String name) {
        QueryWrapper<SysUser> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUser::getUsername,name);
        return this.baseMapper.selectOne(queryWrapper);
    }

    /**
     * 根据用户id查询角色集合
     * @param id
     * @return
     */
    @Override
    public List<SysRole> selectSysRoleByUserId(Long id) {
        return this.baseMapper.selectSysRoleByUserId(id);
    }

    /**
     * 通过用户id查询权限集合
     * @param id
     * @return
     */
    @Override
    public List<SysMenu> selectSysMenuByUserId(Long id) {
        return this.baseMapper.selectSysMenuByUserId(id);
    }
}
