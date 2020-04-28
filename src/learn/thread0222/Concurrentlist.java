package learn.thread0222;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 容器
 * 
 * @author liuhao
 *
 */
public class Concurrentlist {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();//普通list 未使用锁
		Vector<String>  vector = new Vector<String>();//添加锁，add,remove为原子性操作
		CopyOnWriteArrayList<String>  copyOnWriteArrayList = new CopyOnWriteArrayList<String>();//读的操作远远高于写，读的时候是枷锁的，效率高，写的时候效率低，因为每次写都是复制一份出来修改好之后直接改变地址引用
		
	  Random random = new Random();
	  Thread [] thread = new Thread[100];
	  System.out.println("数组长度："+thread.length);
	  long start = System.currentTimeMillis();
		for(int i =0 ; i < thread.length;i++) {
			thread[i] = new Thread(()->{
				copyOnWriteArrayList.add("s:"+random.nextInt(1000));
			});
		}
		Arrays.asList(thread).forEach(r->r.start());//启动
		
		
		long end = System.currentTimeMillis();
		System.out.println("集合大小："+vector.size()+"时间差："+(end-start));
	}
}
