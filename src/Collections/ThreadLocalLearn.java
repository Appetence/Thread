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
     * 最根本原因是   对象的引用可以分为强引用（虚拟机不会主动回收该块地址的引用，必须将引用的地址以显式地赋值为null，才会被垃圾回收器回收）
     *                              弱引用（jvm垃圾回收时候无论是否内存是否充足都会回收弱引用指向的地址）
     *
     *
     * ThreadLocal的实现原理，每一个Thread维护一个ThreadLocalMap，key为使用弱引用的ThreadLocal实例，value为线程变量的副本。这些对象之间的引用关系如下,
     *
     * ThreadLocal 内存泄漏的原因
     * 从上图中可以看出，ThreadLocalMap使用ThreadLocal的弱引用作为key，如果一个ThreadLocal不存在外部强引用时，Key(ThreadLocal)势必会被GC回收，这样就会导致ThreadLocalMap中key为null， 而value还存在着强引用，只有thead线程退出以后,value的强引用链条才会断掉。
     *
     * 但如果当前线程再迟迟不结束的话，这些key为null的Entry的value就会一直存在一条强引用链：
     *
     * Thread Ref -> Thread -> ThreaLocalMap -> Entry -> value
     * 永远无法回收，造成内存泄漏。
     *
     * 那为什么使用弱引用而不是强引用？？
     * 我们看看Key使用的
     *
     * key 使用强引用
     * 当hreadLocalMap的key为强引用回收ThreadLocal时，因为ThreadLocalMap还持有ThreadLocal的强引用，如果没有手动删除，ThreadLocal不会被回收，导致Entry内存泄漏。
     *
     * key 使用弱引用
     * 当ThreadLocalMap的key为弱引用回收ThreadLocal时，由于ThreadLocalMap持有ThreadLocal的弱引用，即使没有手动删除，ThreadLocal也会被回收。当key为null，在下一次ThreadLocalMap调用set(),get()，remove()方法的时候会被清除value值。
     *
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
