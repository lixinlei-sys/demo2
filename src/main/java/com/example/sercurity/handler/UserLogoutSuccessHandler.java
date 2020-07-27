package com.example.sercurity.handler;

import com.example.common.utils.ResultUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登出成功处理类
 */
@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {

    /**
     * 用户登出成功返回结果
     * 这里应该让前端清楚token
     * @param httpServletRequest
     * @param httpServletResponse
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Map<String,Object> resultData=new HashMap<>();
        resultData.put("code","200");
        resultData.put("message","登出成功");
        SecurityContextHolder.clearContext();
        ResultUtil.responseJson(httpServletResponse,ResultUtil.resultSuccess(resultData));
    }
}
