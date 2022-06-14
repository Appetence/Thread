package thread.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-06-04 14:27
 */
public class MyThreadFunction implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        if (thread.isDaemon()) {
            // 非守护线程
            thread.setDaemon(false);
        }
        if (thread.getPriority() != Thread.NORM_PRIORITY) {
            // 默认优先级
            thread.setPriority(Thread.NORM_PRIORITY);
        }
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("自定义，有异常");
            }
        });
        return thread;
    }/*
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    MyThreadFunction() {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() :
                Thread.currentThread().getThreadGroup();
        namePrefix = "pool-" +
                poolNumber.getAndIncrement() +
                "-thread-";
    }
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r,
                namePrefix + threadNumber.getAndIncrement(),
                0);
        if (t.isDaemon())
            t.setDaemon(false);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }*/
}
