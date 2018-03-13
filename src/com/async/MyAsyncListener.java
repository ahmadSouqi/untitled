package com.async;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import java.io.IOException;

/**
 * Created by asouqi on 3/8/18.
 */
public class MyAsyncListener implements AsyncListener {
    @Override
    public void onComplete(AsyncEvent asyncEvent) throws IOException {
        System.out.println("complete...............");
    }

    @Override
    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        System.err.println("TimeOut????????????");
    }

    @Override
    public void onError(AsyncEvent asyncEvent) throws IOException {
        System.err.println("Error????????????");
    }

    @Override
    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
        System.out.println("Start...............");
    }
}
