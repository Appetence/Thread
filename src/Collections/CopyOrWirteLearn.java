package Collections;

import java.util.*;
import java.util.concurrent.*;

/**
 * 写时复制
 *
 * 在向容器中添加一个元素时，不直接添加而是先把元素复制一份出来然后在新的位置进行添加，
 * 添加成功后将元素的引用指向新的位置，实现读写分离
 */
public class CopyOrWirteLearn {
    /**
     * 高并发情况下为了保证数据的一致性可以用如下方法解决
     * Vector
     * Collections.synchronizedList(new ArrayList<>());
     * ConcurrentHashMap
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        CopyOnWriteArraySet arrayList = new CopyOnWriteArraySet( );
//        ArrayList arrayList = new ArrayList();
        //所有的list基本操作方法上加了
        List<String> arrayList = Collections.synchronizedList(new ArrayList<String>());
        for (int i = 0; i <4 ; i++) {
            executorService.submit(()->{
                arrayList.add(UUID.randomUUID().toString());
            });
        }
        executorService.shutdown();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(arrayList);
        System.out.println("Collections.synchronizedList add method cost time is ");
    }
}