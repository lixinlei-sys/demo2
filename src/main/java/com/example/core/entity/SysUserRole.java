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
 * 用户与角色关系表
 * </p>
 *
 * @author li
 * @since 2020-07-21
 */
@Data
@TableName("sys_user_role")
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户与角色关系Id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;


}
