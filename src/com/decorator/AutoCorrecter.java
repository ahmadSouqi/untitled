package com.decorator;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by asouqi on 3/6/18.
 */

@WebFilter(urlPatterns = "/*", asyncSupported = true)
public class AutoCorrecter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest=(HttpServletRequest)servletRequest;
        MyDecorator decorator=new MyDecorator(httpRequest);
        filterChain.doFilter(decorator,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
