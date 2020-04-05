package org.hqf.tutorials.java.jvm.threads.pool.common;

import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.currentThread;

@ToString
public final class MyTaskCallable implements Callable<String> {

    private final String value;

    public MyTaskCallable(String value) { this.value = value; }

    @Override
    public String call() throws InterruptedException {
        String result = doWork();
        return handleResult(result);
    }

    private String doWork() throws InterruptedException {
        int sleep = ThreadLocalRandom.current().nextInt(10) * 1000;
        System.out.println(currentThread()+" "+value+" ：sleep in " + sleep);
        Thread.sleep(sleep);
        return value;
    }

    private String handleResult(String result) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :mm:ss.SSSZ");
        System.out.println(currentThread()+" result is " + result+" @ "+simpleDateFormat.format(new Date()));
        return "executed at "+new Date().toString();
    }

}