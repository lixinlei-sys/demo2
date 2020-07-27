package com.example.core.service.impl;

import com.example.core.entity.SysRole;
import com.example.core.mapper.SysRoleMapper;
import com.example.core.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author li
 * @since 2020-07-21
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

}
