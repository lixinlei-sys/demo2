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
 * 权限表
 * </p>
 *
 * @author li
 * @since 2020-07-21
 */
@Data
@TableName("sys_menu")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限标识
     */
    private String permission;


}
