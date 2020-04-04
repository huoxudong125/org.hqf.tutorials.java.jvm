package org.hqf.tutorials.java.jvm.threads.pool.fixed;

import lombok.val;
import org.hqf.tutorials.java.jvm.threads.pool.common.MyTaskCallable;
import org.hqf.tutorials.java.jvm.threads.pool.common.MyTaskRunnable;
import org.hqf.tutorials.java.jvm.threads.pool.common.ThreadFactoryWithNamePrefix;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class FixedThreadPooler {

        public static void main(String[] args)
        {
            val executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2,
                    new ThreadFactoryWithNamePrefix("HQF-FIXED-Pool-"));



            for (int i = 1; i <= 500; i++)
            {
                MyTaskRunnable myTaskRunnable = new MyTaskRunnable("Task-Create-By-HQF-FIXED" + i);
                System.out.println("Created Runnable : " + myTaskRunnable.getName());

                executor.execute(myTaskRunnable);
            }
//            executor.shutdown();

            try {
               val executor2 = (ThreadPoolExecutor) Executors.newFixedThreadPool(2,
                        new ThreadFactoryWithNamePrefix("HQF-FIXED-Pool-"));
                for (int i = 1; i <= 500; i++)
                {
                    MyTaskCallable myTaskRunnable = new MyTaskCallable("Task-Create-By-HQF-FIXED" + i);
                    System.out.println("Created Callable: " + myTaskRunnable.call());

                    executor2.submit(myTaskRunnable);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}


