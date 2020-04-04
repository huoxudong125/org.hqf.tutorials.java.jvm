package org.hqf.tutorials.java.jvm.threads.pool.fixed;

import org.hqf.tutorials.java.jvm.threads.pool.ThreadFactoryWithNamePrefix;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Executing : " + name+ " ,duration :"+duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class FixedThreadPooler {

        public static void main(String[] args)
        {
            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2,
                    new ThreadFactoryWithNamePrefix("HQF-FIXED-Pool-"));

            for (int i = 1; i <= 500; i++)
            {
                Task task = new Task("Task-Create-By-HQF-FIXED" + i);
                System.out.println("Created : " + task.getName());

                executor.execute(task);
            }
            executor.shutdown();
        }
}


