package learn.thread0222;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * 常用的并发容器
 * @author liuhao
 *
 */
public class ConcurrentLearn {

	private static Map<String,Object> hashmap = new HashMap<String,Object>();//可以放空值，但是current类型的无法放空值
	private static Map<String,Object> hashtree = new TreeMap<String,Object>();//排序

	private static Map<String,Object> hashtable = new Hashtable<String,Object>();//线程安全，效率低	10W数据3500ms
	private static Map<String,Object> concurrenthashmap = new ConcurrentHashMap<String, Object>();//高并发容器  10万数据3600ms
	private static Map<String,Object> concurrentskiplist = new ConcurrentSkipListMap<String, Object>();//高并发同时排序
	
	
	public static void main(String[] args) {
		/**
		 * 
		 */
		
		Map<String,Object> m = Collections.synchronizedMap(new HashMap<String,Object>());//传入一个不加锁的map返回一个加锁的集合
		
		
		Thread [] arr = new Thread[1000000000]; //长度为100的空数组
		Random random = new Random();
		CountDownLatch countDownLatch  =  new CountDownLatch(arr.length);//作为依据证明数组已经放满
		
		long start = System.currentTimeMillis();
		for(int i = 0 ; i < arr.length;i++) {
			arr[i] = new Thread(()->{
				//将线程放到数组中
				hashtable.put("a"+random.nextInt(1000000000), "a"+random.nextInt(1000000000));
				//concurrenthashmap.put("a"+random.nextInt(1000000000), "a"+random.nextInt(1000000000));
				countDownLatch.countDown();//减1
			}) ;
		}
		Arrays.asList(arr).forEach(r->r.start());//启动项目
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("时间："+(end-start));
	}
	
	
	
	
	
	
}
