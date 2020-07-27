package com.example.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author li
 * @since 2020-07-21
 */
@Data
@TableName("sys_role")
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;


}
