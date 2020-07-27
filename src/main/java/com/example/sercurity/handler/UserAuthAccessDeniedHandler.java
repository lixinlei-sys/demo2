package com.example.sercurity.handler;

import com.example.common.utils.ResultUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 暂无权限处理类
 */
@Component
public class UserAuthAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * 暂无权限返回结果
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(403,"未授权"));
    }
}
