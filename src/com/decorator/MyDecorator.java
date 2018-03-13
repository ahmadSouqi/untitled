package com.decorator;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by asouqi on 3/6/18.
 */
public class MyDecorator extends HttpServletRequestWrapper {

    private HttpServletRequest request;

    public MyDecorator(HttpServletRequest request) {
        super(request);
        this.request=request;
    }

    @Override
    public String getParameter(String name) {
        return autoCorrect(request.getParameter(name));
    }

    private String autoCorrect(String parm){
        if (parm==null)
            return "";
        parm=parm.trim();
        int length=parm.length();
        boolean lastSpace=false;
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<length;i++){
            char c=parm.charAt(i);
            if (c==' '){
                if (!lastSpace)
                    builder.append(c);
                lastSpace=true;
            }
            else{
                builder.append(c);
                lastSpace=false;
            }
        }
        return builder.toString();
    }
}
