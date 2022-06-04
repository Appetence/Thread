package thread.thread0304;

import java.util.concurrent.Executor;

public class ThreadPoolLearm implements Executor {

	public static void main(String[] args) {
		new ThreadPoolLearm().execute(()->{System.out.println("===========");});;
	}

	@Override
	public void execute(Runnable command) {
		//可以自己实现调用
		command.run();//实现executor借口相当于run方法调用
	}

}
