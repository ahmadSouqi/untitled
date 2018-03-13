package com.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by asouqi on 3/8/18.
 */
@WebServlet(name = "AsyncServlet", urlPatterns = "/AsyncServlet.do",
             asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final AsyncContext context=request.startAsync();
        PrintWriter writer=response.getWriter();

        response.setContentType("text/html");
        writer.println("<html><title>AsyncServlet</title><body>" +
                "<div id='progress'></div>");
        context.setTimeout(60000);
        context.addListener(new MyAsyncListener());
        context.start(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    writer.println("<script>" +
                            "document.getElementById('progress').innerHTML=" +
                             " ' "+(i*10)+"% complete' " +
                            "</script>");
                    writer.flush();
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        System.out.println(e);
                    }
                }
                writer.println("<script>" +
                        "document.getElementById('progress').innerHTML=" +
                        " 'Done' " +
                        "</script>");
                writer.println("</body></html>");
                writer.flush();
                context.complete();
            }
        });
    }
}
