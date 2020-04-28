package learn.thread0301;

import learn.util.DateUtil;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueLearn {
	// 阻塞式队列,满了就等待，
	static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();//无界队列
	static Random r = new Random();
	static int count = 40000;
	static long time = 0;
	static long start = 0;
	static long end = 0;
	String context = 0+"";
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(count*5);
		CountDownLatch countDownLatch2 = new CountDownLatch(5);
		//新建一个线程将数据放到队列中
		start = System.currentTimeMillis();
		for(int k = 0 ; k < 5 ;k++){
			new Thread(()->{
				for(int i = 0 ; i < count ; i++) {
					countDownLatch.countDown();
					System.out.println(Thread.currentThread().getName()+":"+i);
					try {
						queue.put(Thread.currentThread().getName()+"aaa:"+i);
							//TimeUnit.MICROSECONDS.sleep(r.nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}


				}
				countDownLatch2.countDown();

				if(queue.size() == count){
					System.out.println("队列大小："+queue.size());
				}


			},"p"+k).start();

		}
		//消费
			try {
				countDownLatch2.await();
				System.out.println("countDown："+queue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i = 0 ; i < 5 ; i ++) {
				new Thread(()->{
					try {
						countDownLatch.await();
						for(;;) {
							try {
								System.out.println(Thread.currentThread().getName()+"TAKE- "+queue.take());
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				
				},"C").start();
				
			}
			while (true){
				if(queue.size() == 0){
					end = System.currentTimeMillis();
					System.out.println("时间："+(DateUtil.TimestampChangeData(end)));
					System.out.println("时间："+(DateUtil.TimestampChangeData(start)));
					System.out.println(DateUtil.getDateResult(DateUtil.TimestampChangeData(start),DateUtil.TimestampChangeData(end)));
					break;
				}

			}
	}
}
