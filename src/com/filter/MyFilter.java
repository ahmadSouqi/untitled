package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by asouqi on 3/6/18.
 */

@WebFilter(filterName = "MyFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "fileName", value = "log.txt"),
        @WebInitParam(name = "prefix", value = " :Url")}
        , asyncSupported = true)
public class MyFilter implements Filter{

    private String fileName;
    private PrintWriter logger;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      fileName=filterConfig.getInitParameter("fileName");
      String path=filterConfig.getServletContext().getRealPath("/");

      try{
          logger=new PrintWriter(new File(path,fileName));
      }
      catch (IOException e){
          System.out.println(e);
          throw new ServletException(e);
      }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        System.out.println(servletRequest.getRemoteAddr());
        logger.println(new Date()+"\t URT: "+httpServletRequest.getRequestURI());
        logger.flush();
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
      if (logger!=null){
          logger.close();
      }
    }
}
