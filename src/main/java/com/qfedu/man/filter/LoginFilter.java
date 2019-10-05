package com.qfedu.man.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.man.common.JsonBean;
import com.qfedu.man.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Order(1)值越小执行优先级越高
//@WebFilter("/*") //  /* 或 *.do  不能 /*.do 语法要求
public class LoginFilter implements Filter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String uri = request.getRequestURI();

        String method = request.getMethod();
        //向请求头中写入数据后，会自动先发一个提交方式是OPTIONS的请求
        //我们不用处理该请求，直接返回
        if (method.equalsIgnoreCase("OPTIONS")){
            return;
        }

        if (uri.contains("login")){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
         //   String token = request.getParameter("token");
            //从请求头中取token
            String token = request.getHeader("token");

            String ajax = request.getHeader("x-requested-with");

            if (token == null || token.equals("")){
                //判断是否ajax请求
                if (ajax != null && ajax.equals("XMLHttpRequest")){
                    JsonBean result = new JsonBean(1,"权限不够");
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonStr = objectMapper.writeValueAsString(result);
                    response.getWriter().write(jsonStr);
                    return;
                }else{
                    //跳转到登录页面
                    response.sendRedirect(request.getContextPath() + "/login.html");
                }
            }else{
                String name = stringRedisTemplate.opsForValue().get(token);
                if (name == null){
                    //判断是否ajax请求
                    if (ajax != null && ajax.equals("XMLHttpRequest")){
                        JsonBean result = new JsonBean(1,"权限不够");
                        ObjectMapper objectMapper = new ObjectMapper();
                        String jsonStr = objectMapper.writeValueAsString(result);
                        response.getWriter().write(jsonStr);
                        return;
                    }else{
                        //跳转到登录页面
                        response.sendRedirect(request.getContextPath() + "/login.html");
                    }

                }else{
                    String token2 = MD5Utils.md5(name + "haha");
                    if (token.equals(token2)){//计算结果一致，放行
                        filterChain.doFilter(servletRequest, servletResponse);
                    }else{
                        //判断是否ajax请求
                        if (ajax != null && ajax.equals("XMLHttpRequest")){
                            JsonBean result = new JsonBean(1,"权限不够");
                            ObjectMapper objectMapper = new ObjectMapper();
                            String jsonStr = objectMapper.writeValueAsString(result);
                            response.getWriter().write(jsonStr);
                            return;
                        }else{
                            //跳转到登录页面
                            response.sendRedirect(request.getContextPath() + "/login.html");
                        }

                    }

                }

            }

        }
    }

    @Override
    public void destroy() {

    }
}
