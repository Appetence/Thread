package jvm.jstack;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-04-26 16:32
 */
public class JstackTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Object o = new Object();
        executorService.submit(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                synchronized (o){
                    while (true){

                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
    }
}
