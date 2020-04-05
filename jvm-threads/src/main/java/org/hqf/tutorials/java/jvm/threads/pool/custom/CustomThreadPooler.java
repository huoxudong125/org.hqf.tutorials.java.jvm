package org.hqf.tutorials.java.jvm.threads.pool.custom;

import lombok.val;
import org.hqf.tutorials.java.jvm.threads.pool.common.MyTaskCallable;
import org.hqf.tutorials.java.jvm.threads.pool.common.RejectedTaskPrintHandler;
import org.hqf.tutorials.java.jvm.threads.pool.common.ThreadFactoryWithNamePrefix;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CustomThreadPooler {

    public static void main(String[] args) {
        try {

            int corePoolSize = 10;
            int maxPoolSize = 20;
            int keepAliveTime = 120;
//            BlockingQueue<Runnable> workQueue = new SynchronousQueue<Runnable>();
            BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(10000);
            val poolExecutor =new ThreadPoolExecutor(corePoolSize,
                    maxPoolSize,
                    keepAliveTime,
                    TimeUnit.SECONDS,
                    workQueue,
                    new ThreadFactoryWithNamePrefix("HQF-CUSTOM-Pool-"),
                    new RejectedTaskPrintHandler());



            List<MyTaskCallable> taskCallableList=new ArrayList<>();
            for (int i = 1; i <= 200; i++) {
                MyTaskCallable myTaskRunnable = new MyTaskCallable("Task-Create-By-HQF-CUSTOM " + i);
                taskCallableList.add(myTaskRunnable);
//                System.out.println("Created Callable: " + myTaskRunnable.call());

                Future<String> future = poolExecutor.submit(myTaskRunnable);

            }
            List<Future<String>> futureList = poolExecutor.invokeAll(taskCallableList);
//            poolExecutor.awaitTermination(60,TimeUnit.MINUTES);
            poolExecutor.shutdown();

            System.out.println("\n========Printing the results======");

            for (int i = 0; i < futureList.size(); i++) {
                Future<String> future = futureList.get(i);
                try {
                    String result = future.get();
                    System.out.println(result);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
