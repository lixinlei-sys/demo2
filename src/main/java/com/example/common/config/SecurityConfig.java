package com.example.common.config;

import com.example.sercurity.UserAuthenticationProvider;
import com.example.sercurity.UserPermissionEvaluator;
import com.example.sercurity.handler.*;
import com.example.sercurity.jwt.JWTAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

/**
 * SpringSecurity配置类
 * @Author Sans
 * @CreateTime 2019/10/1 9:40
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启权限注解,默认是关闭的
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 自定义登录成功处理器
     */
    @Autowired
    private UserLoginSuccessHandler userLoginSuccessHandler;
    /**
     * 自定义登录失败处理器
     */
    @Autowired
    private UserLoginFailureHandler userLoginFailureHandler;
    /**
     * 自定义注销成功处理器
     */
    @Autowired
    private UserLogoutSuccessHandler userLogoutSuccessHandler;
    /**
     * 自定义暂无权限处理器
     */
    @Autowired
    private UserAuthAccessDeniedHandler userAuthAccessDeniedHandler;
    /**
     * 自定义未登录的处理器
     */
    @Autowired
    private UserAuthenticationEntryPointHandler userAuthenticationEntryPointHandler;
    /**
     * 自定义登录逻辑验证器
     */
    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    /**
     * 加密方式
     * @Author Sans
     * @CreateTime 2019/10/1 14:00
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /**
     * 注入自定义PermissionEvaluator
     */
    @Bean
    public DefaultWebSecurityExpressionHandler userSecurityExpressionHandler(){
        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setPermissionEvaluator(new UserPermissionEvaluator());
        return handler;
    }

    /**
     * 配置登录验证逻辑
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        //这里可启用我们自己的登陆验证逻辑
        auth.authenticationProvider(userAuthenticationProvider);
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        // "*.jpg","classpath:/static/**","classpath:/WEB-INF/jsp/**","classpath:/META-INF/resources/"
        web.ignoring().antMatchers("/static/**","/WEB-INF/jsp/**");
    }

    /**
     * 配置security的控制逻辑 链式编程
     * @Author Sans
     * @CreateTime 2019/10/1 16:56
     * @Param  http 请求
     */
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/index").access("hasAnyRole()")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/index")
                .and()
                .logout()
                .and()
                .csrf()
                .and()
                .rememberMe();
    }*/
   
     @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 容许基于使用httpServletRequest限制访问
        http.authorizeRequests()
                // 不进行权限验证的请求或资源(从配置文件中读取)
                .antMatchers(JWTConfig.antMatchers.split(",")).permitAll()
                .antMatchers("/index").hasRole("USER")
                //.antMatchers("/index","classpath:/webapp/static/**","/login/**","/favicon.ico","classpath:/META-INF/resources/**","classpath:/resources/**","classpath:/static/**","classpath:/public/").permitAll()
                //.antMatchers("/index","/login/**","/favicon.ico").permitAll()
                // 其他的需要登陆后才能访问
                .anyRequest().authenticated()
                .and()
                // 配置未登录自定义处理类
                .httpBasic().authenticationEntryPoint(userAuthenticationEntryPointHandler)
                .and()
                // 配置登录地址
                .formLogin()
                
                //页面无法跳转  俩种方式：1.注释掉自定义登录成功处理类 2.在自定义处理类中response.senRedirect() 来重定向页面
                // 默认登录页面
                .loginPage("/login")
                .loginProcessingUrl("/login") //当发现是 /login时认为是登录，必须和表单提交地址一样
                //.defaultSuccessUrl("/index") //访问指定页面，用户未登录，跳转至登入页面，如果登入成功，跳转至用户访问指定页面，用户访问登入页面，默认的跳转页面
                .successForwardUrl("/index") //登入成功后跳转得页面
                // 配置登录成功自定义处理类
                //.successHandler(userLoginSuccessHandler)
                // 配置登录失败自定义处理类
                .failureHandler(userLoginFailureHandler)
                .and()
                  
                // 配置登出地址
                .logout()
                .logoutUrl("/login/userLogout")
                // 配置用户登出自定义处理类
                .logoutSuccessHandler(userLogoutSuccessHandler)
                .and()
                // 配置没有权限自定义处理类
                .exceptionHandling().accessDeniedHandler(userAuthAccessDeniedHandler)
                .and()
                // 开启跨域
                .cors()
                .and()
                // 取消跨站请求伪造防护 防止网站被攻击（get方式）
                .csrf().disable() //关闭csrf功能 类似于防火墙得功能
                // 开启记住我功能 cookie：默认保存俩周
                .rememberMe()
                .and()
                // frame 嵌套页面时使用
                //       disable: 禁用
                //       deny: 表示该页面不允许在frame中展示,即便是在相同得域名页面嵌套也不允许
                //       sameOrigin: 表示该页面可以在相同域名页面下frame中展示
                //       ALLOW-FROM https://example.com/ — 表示该页面可以在指定来源的 frame 中展示
                .headers().frameOptions().disable();
        ;

        // 基于Token不需要session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 禁用缓存
        http.headers().cacheControl();
        // 添加JWT过滤器
        http.addFilter(new JWTAuthenticationTokenFilter(authenticationManager()));
    }
   
   
   
   
    
}