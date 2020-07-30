package com.example.common.utils;

import com.example.sercurity.entity.SelfUserEntity;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Security工具类
 * @CreateTime 
 */
public class SecurityUtil {

    /**
     * 私有化构造器
     */
    private SecurityUtil(){}

    /**
     * 获取当前用户信息
     * @return
     */
    public static SelfUserEntity getUserInfo(){
        SelfUserEntity userDetails= (SelfUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails;
    }

    /**
     * 获取当前用户id
     * @return
     */
    public static Long userId(){return  getUserInfo().getUserId(); }

    /**
     * 获取当前用户账号
     * @return
     */
    public static String userName(){return getUserInfo().getUsername();}
}
