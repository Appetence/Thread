package learn.thread0221;

/**
 * 单例模式的实现,不用加锁，同时可以懒加载
 * 
 * @author liuhao
 *
 */
public class Singletion {
	
	public Singletion() {
		
	}
	//匿名内部类调用
	private static class inner {
		static Singletion si = new Singletion();
	}
	public static Singletion getSingletion() {
		return inner.si;
	}
	
	public static void main(String[] args) {
		
		System.out.println("");
		for(int i = 0 ; i < 10 ; i++) {
			new Thread(()->{}).start();;
		}
		
		
	}
}
