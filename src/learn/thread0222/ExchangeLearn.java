package learn.thread0222;

import java.util.concurrent.*;

/**
 * @program: Thread
 * @description: 交换两个线程之间的入参
 * @author: liuhao
 * @date: 2022-07-13 14:42
 */
public class ExchangeLearn {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(() -> {
            trade("曼联", "梅西", exchanger);
        });
        threadPoolExecutor.execute(() -> {
            trade("英超", "贝克汉姆", exchanger);
        });
        threadPoolExecutor.execute(() -> {
            trade("曼哈顿", "梅西", exchanger);
        });
        threadPoolExecutor.execute(() -> {
            trade("英皇", "贝克汉姆", exchanger);
        });
    }

    private static void trade(String t, String o, Exchanger exchanger) {
        System.out.println(Thread.currentThread().getId() + "，" + t + "出售" + o);
        try {
            String info = (String) exchanger.exchange(o);
            System.out.println(Thread.currentThread().getId() + "，" + t + "得到" + info);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
