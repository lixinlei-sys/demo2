package com.example.common.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;


public class ResponseUtil extends HttpServletResponseWrapper {
    public ResponseUtil(HttpServletResponse response) {
        super(response);
        response.setContentType("text/javascript");
    }
}
