package thread.forkJoin;

import java.io.IOException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-05-31 16:38
 */
public class ForkJoinThreadExcutePoolLearn {
    public static void main(String[] args) throws IOException, InterruptedException {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> {
            System.out.println(">>>>");
        });
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.SECONDS);


    }
}
