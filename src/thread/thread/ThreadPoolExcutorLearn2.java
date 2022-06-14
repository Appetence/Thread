package thread.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-06-04 15:55
 */
public class ThreadPoolExcutorLearn2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        MyThreadPoolExecutor threadPoolExecutor = new MyThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),new MyThreadFunction());
        List<Callable<Integer>> list = new LinkedList<>();
        list.add(()-> 1);
        list.add(()-> 2);
        list.add(()-> 3);
        list.add(()-> 4);
//        List<Future<Integer>> futures = threadPoolExecutor.invokeAll(list,3,TimeUnit.SECONDS);
        Integer futures = threadPoolExecutor.invokeAny(list,1,TimeUnit.SECONDS);
        System.out.println(futures.toString());
    }
}
