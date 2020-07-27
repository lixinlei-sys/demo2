package com.example.common.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;


import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果工具类
 */
@Slf4j
public class ResultUtil {

    /**
     * 私有构造器
     */
    private ResultUtil(){}

    /**
     * 使用response输出json
     * @param response
     * @param resultMap 数据
     */
    public static void responseJson(ServletResponse response, Map<String,Object> resultMap) {
        PrintWriter out=null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try {
            out=response.getWriter();
            out.println(JSON.toJSONString(resultMap));
        } catch (IOException e) {
            e.printStackTrace();
            log.error("【JSON输出异常】"+e);
        }finally {
            if (out!=null){
                out.flush();
                out.close();
            }
        }
    }

    /**
     * 返回成功示例
     * @param resultMap 返回数据Map
     * @return
     */
    public static Map<String,Object> resultSuccess(Map<String,Object> resultMap){
        resultMap.put("message","操作成功");
        resultMap.put("code",200);
        return resultMap;
    }

    /**
     * 失败返回示例
     * @param resultMap 返回数据map
     * @return
     */
    public static Map<String,Object> resultError(Map<String,Object> resultMap){
        resultMap.put("message","操作失败");
        resultMap.put("code",500);
        return resultMap;
    }

    /**
     * 通用示例
     * @param code 信息码
     * @param msg 信息
     * @return Map<String,Object> 返回数据Map
     */
    public static Map<String,Object> resultCode(Integer code,String msg){
        Map<String,Object> resultMap=new HashMap<String, Object>();
        resultMap.put("message",msg);
        resultMap.put("code",code);
        return resultMap;
    }
}
