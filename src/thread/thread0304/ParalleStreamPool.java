package thread.thread0304;

import java.util.LinkedList;
import java.util.Random;

/**
 * parallstreamapi ,默认使用多线程
 * 
 * @author liuhao
 *
 */
public class ParalleStreamPool {
	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 1000000; i++) {
			list.add(random.nextInt(99));
		}
		;
		long start = System.currentTimeMillis();
		list.forEach(e -> isPrime(e));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		 start = System.currentTimeMillis();
		list.parallelStream().forEach(ParalleStreamPool::isPrime);
		 end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	static boolean isPrime(int num) {
		for (int i = 2; i < num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return false;
	}
}
