package learn.thread0301;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueLiearn {
	
static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);

public static void main(String[] args) throws InterruptedException {
	
	for(int i = 0 ; i < 10 ; i ++) {
		try {
			queue.put(i+"2");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//当arrayblockingqueue已满时继续放入
	queue.add("1");//null exception
	queue.offer("");//正常执行，但是值无法放入
	queue.put("1");//阻塞
	queue.offer("1",1,TimeUnit.SECONDS);//1s之后添加，失败则不添加
}
}
