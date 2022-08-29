package thread.thread0304;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时线程池
 * @author liuhao
 *
 */
public class ThreadPoolScheduleLearn {
public static void main(String[] args) {
	ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
	/*
	scheduledExecutorService.scheduleAtFixedRate(()->{
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//定时执行的方法
		System.out.println("线程名"+Thread.currentThread().getName());
	}, 0, 500, TimeUnit.MILLISECONDS);//指定规则执行
	*/
	scheduledExecutorService.scheduleWithFixedDelay(()->{
		try {
			TimeUnit.MICROSECONDS.sleep(1000);
			System.out.println("///"+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}, 10, 10, TimeUnit.SECONDS);//前一个线程结束多久之后执行
	
}
}
