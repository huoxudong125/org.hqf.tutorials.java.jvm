package org.hqf.tutorials.java.jvm.threads.pool.custom;

import lombok.val;
import org.hqf.tutorials.java.jvm.threads.pool.common.MyTaskCallable;
import org.hqf.tutorials.java.jvm.threads.pool.common.ThreadFactoryWithNamePrefix;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CustomThreadPooler {

    public static void main(String[] args) {
        try {

            int corePoolSize = 10;
            int maxPoolSize = 1000;
            int keepAliveTime = 120;
            BlockingQueue<Runnable> workQueue = new SynchronousQueue<Runnable>();
            val poolExecutor =new ThreadPoolExecutor(corePoolSize,
                    maxPoolSize,
                    keepAliveTime,
                    TimeUnit.SECONDS,
                    workQueue,
                    new ThreadFactoryWithNamePrefix("HQF-CUSTOM-Pool-"));

            List<Future<String>> futureList=new ArrayList<>();
            for (int i = 1; i <= 500; i++) {
                MyTaskCallable myTaskRunnable = new MyTaskCallable("Task-Create-By-HQF-CUSTOM" + i);
                System.out.println("Created Callable: " + myTaskRunnable.call());

                Future<String> future = poolExecutor.submit(myTaskRunnable);
                futureList.add(future);

            }

            poolExecutor.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
