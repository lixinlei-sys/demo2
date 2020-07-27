package com.example.core.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色与权限关系表
 * </p>
 *
 * @author li
 * @since 2020-07-21
 */
@Data
@TableName("sys_role_menu")
public class SysRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色与权限关系Id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 权限ID
     */
    private Long menuId;


}
