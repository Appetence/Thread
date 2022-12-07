package thread.random.ThreadRandomTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;

/**
 * @program: Thread
 * @description: 随机数种子生成，并发情况下会重复
 * @author: liuhao
 * @date: 2022-12-06 17:25
 */
public class ThreadRandomTest {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        R internal = R.getInternal();
        internal.singletonTest();
//        internal.current();
    }


}

class R {
    public static R R;

    public static R getInternal() {
        if (Objects.isNull(R)) {
            R = new R();
        }
        return R;
    }

    public void singletonTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        Class<ThreadLocalRandom> aClass = ThreadLocalRandom.class;
        Method getProbe = aClass.getDeclaredMethod("getProbe");
        getProbe.setAccessible(true);
        Method advanceProbe = aClass.getDeclaredMethod("advanceProbe", int.class);
        advanceProbe.setAccessible(true);
        int h;
        Object invoke = getProbe.invoke(current);
        System.out.println(getProbe.invoke(current));
        System.out.println(getProbe.invoke(current));

        h = (int) invoke;
        int advResult = (int) advanceProbe.invoke(current, h);
        System.out.println(advResult);
        System.out.println(getProbe.invoke(current));
        System.out.println(getProbe.invoke(current));
        // 本质是对传入的参数进行与 + 偏移散列，并发小时候不会重复，并发大时候会重复
        int advResult1 = (int) advanceProbe.invoke(current, h);
        System.out.println(advResult1);
        System.out.println(getProbe.invoke(current));
        System.out.println(getProbe.invoke(current));
        h = advResult;
        int advresult = (int) advanceProbe.invoke(current, h);
        System.out.println(advresult);
        System.out.println(getProbe.invoke(current));
        System.out.println(getProbe.invoke(current));
    }

    public void current() {
        int size = 1500;
        CountDownLatch countDownLatch = new CountDownLatch(size);
        ExecutorService executorService = Executors.newFixedThreadPool(size);
        Set<Integer> s =  ConcurrentHashMap.<Integer>newKeySet();
        List<Future<Boolean>> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Future<Boolean> submit = executorService.submit(() -> {
                ThreadLocalRandom current = ThreadLocalRandom.current();
                Class<? extends ThreadLocalRandom> aClass = current.getClass();
                HashSet<Integer> objects = new HashSet<>();
                for(int j = 0 ;j < size;j ++){
                    try {
                        Method getProbe = aClass.getDeclaredMethod("getProbe");
                        getProbe.setAccessible(true);
                        Method advanceProbe = aClass.getDeclaredMethod("advanceProbe", int.class);
                        advanceProbe.setAccessible(true);
                        countDownLatch.countDown();
                        countDownLatch.await();
                        // 种子
                        Object invoke = getProbe.invoke(current);
                        Object adv = advanceProbe.invoke(current, (int) invoke);
                        objects.add((int) adv);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }
                s.addAll(objects);
                return true;
            });
            list.add(submit);
        }
        while (!list.stream().allMatch(item -> {
            try {
                return item.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        })){
            System.out.println("wait...");
        }
        System.out.println("count getProbe "+ size * size);
        System.out.println("set size is "+ s.size());
        executorService.shutdown();

    }


}