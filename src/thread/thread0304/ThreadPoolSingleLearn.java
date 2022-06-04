package thread.thread0304;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单例模式执行 ，保证任务顺序执行
 * @author liuhao
 *
 */
public class ThreadPoolSingleLearn {
public static void main(String[] args) {
	ExecutorService executorService = Executors.newSingleThreadExecutor();
	for(int i =0;i<5 ;i++) {
		final int j = i ;
		executorService.execute(()->{
			System.out.println(j+"///"+Thread.currentThread().getName());
		});
	}
}
}
