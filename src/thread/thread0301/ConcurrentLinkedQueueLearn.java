package thread.thread0301;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueLearn {
	public static void main(String[] args) {
		//内部加锁队列
		Queue<String> queue = new ConcurrentLinkedQueue<String>();
		for (int i = 0; i < 10; i++) {
			queue.offer("S:"+i);//类似于add
		}
		System.out.println(queue);
		System.out.println(queue.size());
		queue.poll();//从对列中取出第一个并删除
		System.out.println(queue.size());
		System.out.println(queue);
		queue.peek();
		System.out.println(queue);
		System.out.println(queue.size());
	}
}
