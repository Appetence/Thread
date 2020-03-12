package learn.thread0301;
/**
 * 
 * 没有容量的课，队列中消息只要未被消费立刻抛异常
 * 
 * @author liuhao
 *
 */

import java.util.concurrent.SynchronousQueue;

public class SynchroizedQueueLearn {
	static SynchronousQueue<String> sq = new SynchronousQueue<String>();
	public static void main(String[] args) throws InterruptedException {
		new Thread(()-> {
			try {
				sq.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		//sq.add("111"); //Exception in thread "main" java.lang.IllegalStateException: Queue full
		sq.put("123");//底层实现用的transfer，是一种特殊的transferqueue，里边的内容必须直接给customer消费否则会阻塞
		System.out.println("jie  shu  le "+sq.size());
	}
}
