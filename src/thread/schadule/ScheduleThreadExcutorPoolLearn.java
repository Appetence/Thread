package thread.schadule;

import thread.thread.MyThreadFunction;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-05-31 16:39
 */
public class ScheduleThreadExcutorPoolLearn {
    public static void main(String[] args) {
        MyScheduleThreadPoolExecutor threadPoolExecutor = new MyScheduleThreadPoolExecutor(2, new MyThreadFunction());

/*
        threadPoolExecutor.schedule(() -> {
            System.out.println(">>>");
        }, 1, TimeUnit.SECONDS);
*/
        // 上一次执行结束后按照延迟执行下一次
//        threadPoolExecutor.scheduleWithFixedDelay(ScheduleThreadExcutorPoolLearn::run, 2, 2, TimeUnit.SECONDS);
        // 上一次结束后下一次 判断执行时间是否满足，满足则执行，不满足则延迟period - exct1 time执行
        threadPoolExecutor.scheduleAtFixedRate(ScheduleThreadExcutorPoolLearn::run, 0, 2, TimeUnit.SECONDS);



//        threadPoolExecutor.shutdown();

    }

    private static void run() {
        System.out.println("open");
        /*try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(">>>");
        System.out.println("end");
    }
}
