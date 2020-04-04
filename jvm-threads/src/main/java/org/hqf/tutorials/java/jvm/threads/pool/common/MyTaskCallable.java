package org.hqf.tutorials.java.jvm.threads.pool.common;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.currentThread;

public final class MyTaskCallable implements Callable<String> {

    private final String value;

    public MyTaskCallable(String value) { this.value = value; }

    @Override
    public String call() throws InterruptedException {
        String result = doWork();
        return handleResult(result);
    }

    private String doWork() throws InterruptedException {
        int sleep = ThreadLocalRandom.current().nextInt(10) * 100;
        System.out.println(currentThread()+" ：sleep in " + sleep);
        Thread.sleep(sleep);
        return value;
    }

    private String handleResult(String result) {
        System.out.println(currentThread()+"result is " + result);
        return "executed at "+new Date().toString();
    }

}