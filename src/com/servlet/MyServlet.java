package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asouqi on 3/5/18. untitled/MyServlet.do
 */

@WebServlet(name = "MyServlet",urlPatterns = "/MyServlet.do")
public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String realUrl=getServletContext().getRealPath("/");
        response.getWriter().println(String.format(
                "<html><body>First servlet <br><br><strong>%s</strong></body></html>",realUrl));
       request.getSession().invalidate();
    }
}
