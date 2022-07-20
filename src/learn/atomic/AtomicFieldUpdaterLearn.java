package learn.atomic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @program: Thread
 * @description:
 * @author: liuhao
 * @date: 2022-07-15 15:53
 */
public class AtomicFieldUpdaterLearn {
    public static class Codition {
        int id;
        volatile int score;
//        private volatile Integer score;
    }

    private static int COUNT = 1000;

    public static void main(String[] args) {
        Codition codition = new Codition();
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT);
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicIntegerFieldUpdater<Codition> score = AtomicIntegerFieldUpdater.newUpdater(Codition.class, "score");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(COUNT, () -> {
            System.out.println("结束等待，同时执行->>>");
        });
        for (int i = 0; i < COUNT; i++) {

            executorService.execute(() -> {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                atomicInteger.incrementAndGet();
                score.incrementAndGet(codition);
            });

        }


        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // 注意 存在重复打印输出的问题
            System.out.println(">>> print");

            System.out.println("atomic " + atomicInteger.get());
            System.out.println("fieldUpload" + codition.score);
        }

    }
}
