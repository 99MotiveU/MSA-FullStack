package com.sts.config;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class JwtFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String[] ignores={"/","/login"};
        HttpServletRequest req=(HttpServletRequest)request;
        if(req.getRequestURI().equals("/")){
            chain.doFilter(request, response);
        }
        if(req.getRequestURI().equals("/login")){
            chain.doFilter(request, response);
        }
        //if()
        throw new UnsupportedOperationException("Unimplemented method 'doFilter'");
    }

}
