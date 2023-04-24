package thread.thread0222;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 做加法运算 三国演义
 *
 *
 *  可以用于限流措施： guava  RateLimiter
 */
public class CyclicBarrierLearn {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            //达到要求后执行 countdownlatch + thread + while
            System.out.println("***********结束啦");
        });
        for (int i = 0; i < 3; i++) {
            int template = i;
            new Thread(() -> {
                try {
                    System.out.println("走到了：" + template);
                    cyclicBarrier.await();//
                    System.out.println("11111:"+cyclicBarrier.getNumberWaiting());
                    System.out.println("33333:"+cyclicBarrier.isBroken());
                    System.out.println("22222:"+cyclicBarrier.getParties());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "线程名：" + i).start();
        }


    }


}
