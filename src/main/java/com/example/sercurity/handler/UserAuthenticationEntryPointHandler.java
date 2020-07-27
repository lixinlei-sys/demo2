package com.example.sercurity.handler;

import com.example.common.utils.ResultUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户未登录处理类
 */
@Component
public class UserAuthenticationEntryPointHandler  implements AuthenticationEntryPoint {
    /**
     * 用户未登录返回结果
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(401,"未登录"));
    }
}
