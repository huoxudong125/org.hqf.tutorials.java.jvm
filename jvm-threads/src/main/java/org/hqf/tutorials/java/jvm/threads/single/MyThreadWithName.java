package org.hqf.tutorials.java.jvm.threads.single;

import org.hqf.tutorials.java.jvm.threads.single.common.MyThread;

public class MyThreadWithName {
    public static void main(String[] args) {
        System.out.println("Main Function executed Start...");

        Thread t=new MyThread();
        t.setName("HQF-Single-Thread-1");
        t.start();

        Thread t2=new MyThread();
        t2.setName("HQF-Single-Thread-2");
        t2.start();

        System.out.println("Main Function executed Finished");
    }
}
