package learn.thread0222;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @program: Thread
 * @description: 类似于countDownLatch
 * @author: liuhao
 * @date: 2022-07-13 14:22
 */
public class CyclicBarrierLearn {
    private final static int USER_MAX = 5;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(USER_MAX ,()->{
            System.out.println("运行结束");
        });

        for(int i = 0 ; i < USER_MAX ; i++){
            new Thread(()->{
                try {
                    System.out.println("准备就绪ß"+Thread.currentThread().getName());
                    cyclicBarrier.await(5, TimeUnit.SECONDS);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
