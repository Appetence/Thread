package jvm.gurbage;

import base.Xiamu;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @program: ThreadLearn
 * @description: 弱引用
 * @author: xiamu
 * @create: 2021-05-14 14:47
 */
public class GC5 {
    public static void main(String[] args) {
        ReferenceQueue<Xiamu> que = new ReferenceQueue();
        WeakReference<Xiamu> weakReference = new WeakReference(new Xiamu(), que);
        Thread thread = new Thread(() -> {
            Reference<? extends Xiamu> remove;
            try {
                while ((remove = que.remove()) != null) {
                    System.out.println("回收了" + remove);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
                thread.setDaemon(true);
        thread.start();
        System.out.println("before gc :" + weakReference.get());
        System.gc();

        System.out.println("after gc :" + weakReference.get());

    }
}
