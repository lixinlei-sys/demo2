package com.example.core.service.impl;

import com.example.core.entity.SysRoleMenu;
import com.example.core.mapper.SysRoleMenuMapper;
import com.example.core.service.SysRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与权限关系表 服务实现类
 * </p>
 *
 * @author li
 * @since 2020-07-21
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

}
