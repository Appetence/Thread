package thread.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-06-04 14:21
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor {
    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, MyThreadFunction myThreadFunction) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,myThreadFunction);
    }
    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }


    @Override
    public void execute(Runnable command) {
        super.execute(command);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
    }
}
