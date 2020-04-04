package org.hqf.tutorials.java.jvm.threads.pool.common;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

public class MyTaskRunnable implements Runnable {
    private String name;

    public MyTaskRunnable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.println(currentThread().getName()+" Executing : " + name+ " ,duration :"+duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
