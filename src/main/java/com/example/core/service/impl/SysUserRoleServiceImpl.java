package com.example.core.service.impl;

import com.example.core.entity.SysUserRole;
import com.example.core.mapper.SysUserRoleMapper;
import com.example.core.service.SysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色关系表 服务实现类
 * </p>
 *
 * @author li
 * @since 2020-07-21
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

}
