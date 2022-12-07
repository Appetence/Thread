package thread.random.ThreadRandomTest;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @program: Thread
 * @description:
 * @author: liuhao
 * @date: 2022-12-06 20:47
 */
public class test {
    public static void main(String[] args) throws InterruptedException {
        Class<ThreadLocalRandom> clazz = ThreadLocalRandom.class;
        Method getMethod = null;
        Method advanceMethod = null;
        try {
            getMethod = clazz.getDeclaredMethod("getProbe");
            advanceMethod = clazz.getDeclaredMethod("advanceProbe", int.class);
            getMethod.setAccessible(true);
            advanceMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        int threadNum = 5;
        int probeTimes = 100000;
        Thread[] ThreadArray = new Thread[threadNum];
        Set<Integer> s = ConcurrentHashMap.<Integer> newKeySet();

        for(int i = 0; i < threadNum; i++) {
            Method finalGetMethod = getMethod;
            Method finalAdvanceMethod = advanceMethod;
            ThreadArray[i] = new Thread(()->{
                ThreadLocalRandom a = ThreadLocalRandom.current();
                int h = 0;
                try{
                    for(int j = 0;j <probeTimes; j++) {
                        if (j == 0) {//第一次去get
                            h = (Integer) finalGetMethod.invoke(a);
                        } else {//之后每次都增加
                            h = (Integer) finalAdvanceMethod.invoke(a, h);
                        }
                        s.add(h);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            ThreadArray[i].start();
        }

        for(int i = 0; i < threadNum; i++) {
            ThreadArray[i].join();
        }
        System.out.println("探针生成的总次数："+threadNum * probeTimes);
        System.out.println("不重复的探针数："+s.size());
    }
}
