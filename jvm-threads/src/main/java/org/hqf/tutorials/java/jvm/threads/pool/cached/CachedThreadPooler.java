package org.hqf.tutorials.java.jvm.threads.pool.cached;

import lombok.val;
import org.hqf.tutorials.java.jvm.threads.pool.common.MyTaskCallable;
import org.hqf.tutorials.java.jvm.threads.pool.common.ThreadFactoryWithNamePrefix;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CachedThreadPooler {

    public static void main(String[] args) {
        try {
            val executor2 = (ThreadPoolExecutor) Executors.newCachedThreadPool(new ThreadFactoryWithNamePrefix("HQF-CACHED-Pool-"));

            for (int i = 1; i <= 500; i++) {
                MyTaskCallable myTaskRunnable = new MyTaskCallable("Task-Create-By-HQF-CACHED" + i);
                System.out.println("Created Callable: " + myTaskRunnable.call());

                executor2.submit(myTaskRunnable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
