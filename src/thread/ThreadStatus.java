package thread;

import thread.thread1126.ThreadSourceTest;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-03-25 14:12
 */
public class ThreadStatus {


    public static void main(String[] args) {
        if(BigDecimal.ZERO.compareTo(new BigDecimal("0.1")) == -1){
            System.out.println(">>>");
        }else {
            System.out.println("<<<>>>>>>");
        }

        ThreadSourceTest threadSourceTest = new ThreadSourceTest();
        if(threadSourceTest instanceof ThreadSourceTest){
            System.out.println(">>>");
        }else {
            System.out.println("<<<>>>>>>");
        }
        ThreadStatusSub threadStatusSub = new ThreadStatusSub();
        Class<? extends ThreadStatusSub> threadStatusSubClass = threadStatusSub.getClass();

        Field[] declaredFields = threadStatusSubClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            System.out.println(name);
        }

        if(threadStatusSub instanceof ThreadStatusParten){
            Class<?> superclass = threadStatusSubClass.getSuperclass();
            Field[] declaredFields1 = superclass.getDeclaredFields();
            for (Field field : declaredFields1) {
                String name = field.getName();
                System.out.println(name);
            }
        }

        Object o = new Object();
        Class<?> superclass = o.getClass().getSuperclass();
        ThreadStatusParten statusParten = (ThreadStatusParten) null;
        System.out.println(superclass);
        boolean planInterest = "planInterest".equals("planInterest");
        System.out.println(planInterest);


    }
}
