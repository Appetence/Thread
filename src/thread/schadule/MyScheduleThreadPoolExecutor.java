package thread.schadule;

import thread.thread.MyThreadFunction;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-06-04 14:21
 */
public class MyScheduleThreadPoolExecutor extends ScheduledThreadPoolExecutor {
    public MyScheduleThreadPoolExecutor(int corePoolSize, MyThreadFunction myThreadFunction) {
        super(corePoolSize, myThreadFunction);
    }

    public MyScheduleThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize);
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
