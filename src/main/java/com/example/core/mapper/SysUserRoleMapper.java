package com.example.core.mapper;

import com.example.core.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户与角色关系表 Mapper 接口
 * </p>
 *
 * @author li
 * @since 2020-07-21
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

}
