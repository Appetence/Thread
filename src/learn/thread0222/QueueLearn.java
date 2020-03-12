package learn.thread0222;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 队列实现多线程处理，
 * 
 * @author liuhao
 *
 */
public class QueueLearn {

	static Queue<String> que = new ConcurrentLinkedQueue<String>();

	static {
		//静态方法块，放入队列数据
		for (int i = 0; i < 1000; i++) {
			que.add("票 编号" + i);
		}
	}

	public static void main(String[] args) {
		//从队列取出数据
		for (int i = 0; i < 10; i++) {
			//10个线程
			 new Thread(()->{
				 while(true) {
					 String s = que.poll();//从队列中取出数据
					 if(s != null) {
						 System.out.println(Thread.currentThread().getName()+"销售："+(s)+"票");
					 }else {
						 break;
					 }
				 }
			 }) .start();
		}
	}
}
