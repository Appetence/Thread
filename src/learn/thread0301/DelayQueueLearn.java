package learn.thread0301;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import learn.thread0301.DelayQueueLearn.MyTask;

/**
 * 和时间挂钩，等待时间最长的最先取出
 * 
 * 做定时任务
 * 
 * @author liuhao
 *
 */
public class DelayQueueLearn {
	static BlockingQueue<MyTask> query = new DelayQueue<MyTask>();
	static Random r = new Random();

	static class MyTask implements Delayed {
		long runningTime;// 结束时间

		public MyTask(long runningTime) {
			super();
			this.runningTime = runningTime;
		}

		@Override
		public int compareTo(Delayed o) {
			if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
				return -1;
			} else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
				return 1;
			} else {
				return 0;
			}
		}

		@Override
		public long getDelay(TimeUnit unit) {
			return unit.convert(runningTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
		}

		@Override
		public String toString() {
			return "" + runningTime;
		}

	}

	public static void main(String[] args) throws InterruptedException {
//		long now = System.currentTimeMillis();
		long now = 10000 + System.currentTimeMillis();
/*		MyTask mt = new MyTask(now + 1000);
		System.out.println(now + 1000);
		MyTask mt1 = new MyTask(now + 2000);
		System.out.println(now + 2000);
		MyTask mt2 = new MyTask(now + 31000);
		System.out.println(now + 31000);
		MyTask mt3 = new MyTask(now + 4000);
		System.out.println(now + 4000);
		MyTask mt4 = new MyTask(now + 500);
		System.out.println(now + 500);
		MyTask mt5 = new MyTask(now + 600);
		System.out.println(now + 600);
		query.put(mt);
		query.put(mt1);
		query.put(mt2);
		query.put(mt3);
		query.put(mt4);
		query.put(mt5);
		System.out.println(query);*/

		// test

		query.put( new MyTask(now + 1000));
		query.put( new MyTask(now + 1000));
		query.put( new MyTask(now + 1000));
		query.put( new MyTask(now + 1000));
		query.put( new MyTask(now + 1000));
		query.put( new MyTask(now + 2000));
		query.put( new MyTask(now + 1500));
		/*
		 * for(MyTask m : query) { System.out.println(query.take());//take通过索引取出元素 }
		 */
		for (int i = 0; i < 6; i++) {
			System.out.println(query.take());//取出首位的元素，如果是空的队列就等待
		}
	}
}
