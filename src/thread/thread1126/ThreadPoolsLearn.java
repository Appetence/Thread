package thread.thread1126;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @program: ThreadLearn
 * @description: 线程池学习
 * @author: liuhao
 * @date: 2021-11-26 10:21
 */
public class ThreadPoolsLearn {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /*final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), new ThreadFactoryBuilder().build(), new ThreadPoolExecutor.AbortPolicy());
        */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3,
                3L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        long start1 = System.currentTimeMillis();
        System.out.println("start >>>" + start1);

        List<Callable<String>> collect = list.stream().map(item -> (Callable<String>) () -> method(item)).collect(Collectors.toList());
        List<Future<String>> futures = threadPoolExecutor.invokeAll(collect);
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }
        long start2 = System.currentTimeMillis();
        threadPoolExecutor.shutdown();
        System.out.println("end >>>" + (start2 - start1));

        System.out.println(">>>>  futureTask  open  <<<<");
        // callable 和 feature 功能集合
        FutureTask futureTask = new FutureTask<String>(() -> {
            System.out.println("futureTask");
            return "futureTask";
        });
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(futureTask);
        Object o = futureTask.get();
        System.out.println(">>>>  " + o);
        System.out.println(">>>>  futureTask  end  <<<<");
        executorService.shutdown();


        //SynchronousQueue  必须上一个任务执行完毕才会执行下一个任务
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //DelayedWorkQueue
        Executors.newScheduledThreadPool(1);
        /**
         * 线程状态
         * New      new()
         * Runable      start,execute ?
         * Running      cpu调度时候
         * block        阻塞io
         * waitting     sleep，wait
         * terminalted  线程终止（执行完毕，或者异常终止）
         */


    }


    public static String method(String key) {
        String keys = ">>>> " + key;
        System.out.println("<<<<" + keys);
        return keys;
    }
}
