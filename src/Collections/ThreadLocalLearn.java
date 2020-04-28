package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class ThreadLocalLearn {

  /*  public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    }*/
    /**
     * 由于该变量只能被当亲线程读取，修改，当任务执行结束线程被回收重新利用的时候可能导致内存泄漏
     */
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalLearn test = new ThreadLocalLearn();


        test.set();
        System.out.println(Thread.currentThread().getName()+":"+test.getLong());
        System.out.println(Thread.currentThread().getName()+":"+test.getString());


        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println(Thread.currentThread().getName()+":"+test.getLong());
                System.out.println(Thread.currentThread().getName()+":"+test.getString());
            };
        };
        thread1.setName("aaa");
        thread1.start();
        thread1.join();

        System.out.println(Thread.currentThread().getName()+":"+test.getLong());
        System.out.println(Thread.currentThread().getName()+":"+test.getString());
    }
}
