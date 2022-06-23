package learn.pool;

import java.util.concurrent.*;

/**
 * @program: Thread
 * @description:
 * @author: liuhao
 * @date: 2022-06-20 19:22
 */
public class CacheThreadPoolLearn {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Runnable> queue = new SynchronousQueue<>();
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                queue);
        for (int i = 0; i < 6; i++) {
            addThread(executorService, i);
        }
        System.out.println(executorService.getTaskCount());
        System.out.println(executorService.getPoolSize());
        System.out.println(executorService.getMaximumPoolSize());
        System.out.println(executorService.getCorePoolSize());
        System.out.println(executorService.getActiveCount());

        executorService.shutdown();
//        executorService.shutdownNow();
        executorService.awaitTermination(1, TimeUnit.SECONDS);

    }

    private static void addThread(ExecutorService executorService, Integer s) {
//        executorService.submit(() -> {
        executorService.execute(() -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s);
        });
    }
}
