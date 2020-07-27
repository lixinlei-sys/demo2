package com.example.core.service.impl;

import com.example.core.entity.SysMenu;
import com.example.core.mapper.SysMenuMapper;
import com.example.core.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author li
 * @since 2020-07-21
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

}
