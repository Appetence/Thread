package thread.thread;

import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-05-31 16:39
 */
public class ThreadPoolExcutorLearn {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyThreadPoolExecutor threadPoolExecutor = new MyThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),new MyThreadFunction());
        System.out.println(threadPoolExecutor.getCorePoolSize());
        threadPoolExecutor.setCorePoolSize(2);
        System.out.println(threadPoolExecutor.getCorePoolSize());
        threadPoolExecutor.execute(() -> {
            System.out.println(">>>>  1");
        });
        threadPoolExecutor.execute(() -> {
            System.out.println("<<>>>>>>   2");
        });
        threadPoolExecutor.execute(() -> {
            System.out.println("<<>>>>>>   3");
            throw new RuntimeException("手动抛出异常测试");
        });


        threadPoolExecutor.shutdown();
        System.out.println(threadPoolExecutor.isTerminated());
        threadPoolExecutor.awaitTermination(10, TimeUnit.MILLISECONDS);
    }



}
