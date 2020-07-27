package com.example.common.utils;

import com.alibaba.fastjson.JSON;
import com.example.common.config.JWTConfig;
import com.example.sercurity.entity.SelfUserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * JWT工具类
 */

@Slf4j
public class JWTTokenUtil {

    /**
     * 生成Token
     * @param selfUserEntity 用户实体类
     * @return
     */
    public static String createAccessToken(SelfUserEntity selfUserEntity){
        // 登录成功生成token
        String token= Jwts.builder()
                // 放入用户名和id
                .setId(selfUserEntity.getUserId()+"")
                // 主题
                .setSubject(selfUserEntity.getUsername())
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer("sans")
                // 自定义属性，放入用户拥有得权限
                .claim("authorities", JSON.toJSONString(selfUserEntity.getAuthorities()))
                // 失效时间
                .setExpiration(new Date(System.currentTimeMillis()+ JWTConfig.expiration))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS512,JWTConfig.secret)
                .compact();

        return token;
    }
}
