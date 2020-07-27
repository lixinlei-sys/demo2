package com.example.sercurity.handler;

import com.example.common.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败处理类
 */
@Slf4j
@Component
public class UserLoginFailureHandler implements AuthenticationFailureHandler {
    /**
     * 登录失败返回结果
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) {
        // 这些对于操作得处理类可以根据不同得异常进行不同得处理
        if (e instanceof UsernameNotFoundException){
            log.info("【登录失败】"+e.getMessage());
            ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(500,"用户名不存在"));
        }
        if (e instanceof LockedException){
            log.info("【登录失败】"+e.getMessage());
            ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(500,"用户被冻结"));
        }
        if (e instanceof BadCredentialsException){
            log.info("【登录失败】"+e.getMessage());
            ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(500,"用户名密码不正确"));
        }
        ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(500,"登录失败"));
    }
}
