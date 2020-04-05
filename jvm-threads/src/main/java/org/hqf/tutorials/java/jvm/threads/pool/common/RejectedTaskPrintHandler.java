package org.hqf.tutorials.java.jvm.threads.pool.common;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 拒绝策略仅为打印被拒绝的 TASK
 */
public class RejectedTaskPrintHandler implements RejectedExecutionHandler
{
    @Override
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor)
    {
        System.out.println(String.format("RejectedTaskHandler: The task %s has been rejected. ",runnable.toString()));
    }
}