package thread.thread0222;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号灯，当有位置的时候执行，满了等待
 *
 * 应用场景     幸运转盘
 */
public class SemaphoreLearn {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            final int temp = i;
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(temp + "抢到车位了！！！！！！！");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("停车三秒后离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放许可证
                }
            },"线程名："+i).start();
        }

    }
}
