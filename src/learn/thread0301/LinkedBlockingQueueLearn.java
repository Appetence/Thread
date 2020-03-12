package learn.thread0301;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueLearn {
	// 阻塞式队列,满了就等待，
	static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();//无界队列
	static Random r = new Random();

	public static void main(String[] args) {
		
		//新建一个线程将数据放到队列中
			new Thread(()->{
				for(int i = 0 ; i < 100 ; i++) {
				try {
					queue.put("aaa:"+i);
					TimeUnit.MICROSECONDS.sleep(r.nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}},"p").start();;
		//消费
			
			for(int i = 0 ; i < 5 ; i ++) {
				new Thread(()->{
					for(;;) {
						try {
							System.out.println(Thread.currentThread().getName()+"TAKE- "+queue.take());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				
				},"C").start();
				
			}
	}
}
