package learn.thread0301;
/**
 * 
 * 没有容量的课，队列中消息只要未被消费立刻抛异常
 * 
 * @author liuhao
 *
 */

import java.io.IOException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchroizedQueueLearn {
	static SynchronousQueue<String> sq = new SynchronousQueue(true);
	public static void main(String[] args) throws InterruptedException, IOException {
		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(1000);
/*				// 队列头部拿元素拿不到，返回null
				String peek = sq.peek();
				System.out.println("peek "+ peek);*/
/*				// 队列头部拿元素，拿不到 异常
				String element = sq.element();
				System.out.println("element "+element);*/
				// blockqueue 获取首元素并移除 获取不到会阻塞  如果获取到的参数为空则抛出异常
				sq.take();
				System.out.println(">>>  1");
				// 获取首元素并移除 获取不到则返回null
				String poll = sq.poll(3, TimeUnit.SECONDS);
				System.out.println(">>>  2" + poll);
//			} catch (InterruptedException e) {
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error >>>");
			}
		});
		thread.start();
		TimeUnit.SECONDS.sleep(1);
//		sq.add("111"); //Exception in thread "main" java.lang.IllegalStateException: Queue full
		sq.put("123");//底层实现用的transfer，是一种特殊的transferqueue，里边的内容必须直接给customer消费否则会阻塞  lockSuport.park(this)
//		sq.offer("123");// 无法放入，直接返回false
		System.out.println("jie  shu  le "+sq.size());
//		System.in.read();
	}
}
