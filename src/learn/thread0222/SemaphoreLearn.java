package learn.thread0222;

import java.util.concurrent.*;

/**
 * @program: Thread
 * @description: 同时可以执行几个任务，注意需要手动释放锁
 * @author: liuhao
 * @date: 2022-07-13 15:07
 */
public class SemaphoreLearn {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(()-> {
                try {
                    semaphore.acquire();
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(">>>>>>");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //手动释放许可
                    semaphore.release();
                }
            });
        }
    }
}
