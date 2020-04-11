package org.hqf.tutorials.java.jvm.threads.single.common;

import java.util.concurrent.ThreadLocalRandom;

public class MyThread extends Thread {
    //run()方法里是线程体
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName() + ":" + i);//getName()方法是返回线程名称

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(10)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
