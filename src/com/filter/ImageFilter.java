package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by asouqi on 3/6/18.
 */

@WebFilter(filterName = "ImageFilter", urlPatterns = {"*.png"}
        , asyncSupported = true)
public class ImageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        String header=request.getHeader("From");
        System.out.println("Header: "+header);
        if (header!=null){
           filterChain.doFilter(servletRequest,servletResponse);
        }
        else{
            throw new ServletException("Image Not Found");
        }

    }

    @Override
    public void destroy() {

    }
}
