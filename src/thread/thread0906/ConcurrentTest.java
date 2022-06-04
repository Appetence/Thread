package thread.thread0906;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-09-06 20:13
 */
public class ConcurrentTest {

    public static volatile ConcurrentHashMap<String, String> map1 = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, String> map2 = new ConcurrentHashMap<>();


    public static void main(String[] args) throws InterruptedException, IOException {
        int size = 8;
        Object o = new Object();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        ExecutorService executorService = Executors.newFixedThreadPool(size);
        for (int i = 0; i < size; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ">>>>");

                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
/*                synchronized (map1) {
                    if (map1.containsKey("key")) {
                    } else {∂

                        System.out.println(">>>>放入");
                        map1.put("key", "key");
                    }
                }*/
                synchronized (map2) {
                    String key = map2.get("key");
                    if (Objects.nonNull(key)) {
                        System.out.println(">>> key get " + map2.get("key"));
                    } else {
                        System.out.println(">>>>放入" + Thread.currentThread().getName());
                        map2.put("key", Thread.currentThread().getName());
                        System.out.println(">>>>取出" + Thread.currentThread().getName() + map2.get("key"));
                    }
                }
            });

        }
        Thread.sleep(3000);
        System.out.println(map1.size());
        System.out.println(map2.size());
        System.out.println(map2.get("key"));
        executorService.shutdown();
    }

}
