package learn.threadJoin;

import java.util.concurrent.TimeUnit;

/**
 * @program: Thread
 * @description:
 * @author: liuhao
 * @date: 2022-07-11 19:52
 */
public class ThreadInterruptLearn {
    private static Thread thread = null;

    public static void main(String[] args) {
        thread =new Thread(() -> {
            method();
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        interruptStats();
        System.out.println("线程中断标识"+thread.isInterrupted());
    }

    private static void interruptStats() {
        thread.interrupt();
    }

    private static void method() {

        while (true){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("收到中断信息，结束任务");
                break;
            }
            System.out.println("执行任务");
            /* 如果有sleep 则抛出异常，被捕获后继续执行并不中断任务
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

    }
}
