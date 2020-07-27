package com.example.core.controller;

import com.example.common.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 初始页面
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController {
    
    //@Value("${jwt.secret}")
   // private String aa;
    
    
    
    /**
     * 首页
     * @return Map<String,Object> 返回数据map
     */
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Map<String, Object> userLogin(){
       // System.out.println("========================================"+aa);
        // 组装参数
        Map<String,Object> result=new HashMap<>();
        result.put("title","这里是首页不需要权限和登录拦截");
        return ResultUtil.resultSuccess(result);
    }
}
