package com.example.sercurity.jwt;

//import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.example.common.config.JWTConfig;
import com.example.sercurity.entity.SelfUserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * JWT接口请求校验拦截器
 * 请求接口时会进入这里验证Token是否合法和过期
 */
@Slf4j
public class JWTAuthenticationTokenFilter extends BasicAuthenticationFilter {
    public JWTAuthenticationTokenFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)  throws ServletException, IOException{
        // 获取请求头中JWT的Token
        String tokenHeader=request.getHeader(JWTConfig.tokenHeader);
        if (tokenHeader!=null && tokenHeader.startsWith(JWTConfig.tokenPrefix)){
            try {
                // 截取Token前缀
                String token=tokenHeader.replace(JWTConfig.tokenPrefix,"");
                // 解析JWT
                Claims claims= Jwts.parser()
                        .setSigningKey(JWTConfig.secret)
                        .parseClaimsJwt(token)
                        .getBody();
                // 获取用户名
                String username=claims.getSubject();
                String userId=claims.getId();
                if (!StringUtils.isEmpty(username)&&!StringUtils.isEmpty(userId)){
                    // 获取角色
                    List<GrantedAuthority> authorities=new ArrayList<>();
                    String authority = claims.get("authority").toString();
                    if (!StringUtils.isEmpty(authority)){
                        List<Map<String,String>> authorityMap= JSONObject.parseObject(authority,List.class);
                        for (Map<String,String> role : authorityMap){
                            if (!StringUtils.isEmpty(role)){
                                authorities.add(new SimpleGrantedAuthority(role.get("authority")));
                            }
                        }
                    }
                    // 组装参数
                    SelfUserEntity selfUserEntity = new SelfUserEntity(); // 用户实体类
                    selfUserEntity.setUsername(claims.getSubject());   // 用户名
                    selfUserEntity.setUserId(Integer.parseInt(claims.getId())); // 用户id
                    selfUserEntity.setAuthorities(authorities);// 用户角色
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(selfUserEntity,userId,authorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken); // 设置认证环境中的认证token
                }
            }catch (ExpiredJwtException e){
                log.info("Token过期");
            }catch (Exception e){
                log.info("Token无效");
            }
            
        }
        filterChain.doFilter(request,response);
        return;
        
    }
}
