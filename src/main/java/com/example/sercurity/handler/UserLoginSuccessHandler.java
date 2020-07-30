package com.example.sercurity.handler;

import com.example.common.config.JWTConfig;
import com.example.common.utils.JWTTokenUtil;
import com.example.common.utils.ResultUtil;
import com.example.sercurity.entity.SelfUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录成功处理类
 */
@Slf4j
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * 登录成功返回结果
     * @param httpServletRequest
     * @param httpServletResponse
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        // 组装JWT
        SelfUserEntity selfUserEntity= (SelfUserEntity) authentication.getPrincipal();
        String token= JWTTokenUtil.createAccessToken(selfUserEntity);
        token= JWTConfig.tokenPrefix+token;
        
        // 封装返回参数
        Map<String,Object> resultData=new HashMap<>();
        resultData.put("code",200);
        resultData.put("message","登录成功");
        resultData.put("token",token);
        httpServletResponse.sendRedirect("/index");
        ResultUtil.responseJson(httpServletResponse,resultData);
        
        
    }
}
