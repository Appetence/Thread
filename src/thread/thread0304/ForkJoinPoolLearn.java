package thread.thread0304;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * forkjoin 将一个项目分成多个子项目，提高效率
 *
 * @author liuhao
 */
public class ForkJoinPoolLearn {
    static Random random = new Random();
    static final int MAX_VAL = 50000;
    static int[] nums = new int[1000000];

    /**
     * 线程运行求取数组的和
     */
    //方法一，数组便利求和
    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
        System.out.println("数组值为" + Arrays.stream(nums).sum());

    }

    //方法二forkjoin
/*	static class AddTask extends RecursiveAction{
		private static final long serialVersionUID = 1L;
		int start ,end;

		public AddTask(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		protected void compute() {
			if(end-start < MAX_VAL) {
				long sum = 0l;
				for(int i = start ; i < end; i ++) {
					sum = sum + nums[i];
				}
				System.out.println(sum);
			}else {
				int middle = start + (end - start)/2;
				AddTask AddTask01 = new AddTask(start,middle);
				AddTask AddTask02 = new AddTask(middle,end);
				AddTask01.fork();
				AddTask02.fork();
			
			}
		}
		
	}*/
    //方法三，RecursiveTask,又返回值
    static class AddTask extends RecursiveTask<Long> {
        private static final long serialVersionUID = 1L;
        int start, end;

        public AddTask(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start < MAX_VAL) {
                long sum = 0l;
                for (int i = start; i < end; i++) {
                    sum = sum + nums[i];
                }
                //System.out.println(sum);
                return sum;
            } else {
                int middle = start + (end - start) / 2;
                AddTask AddTask01 = new AddTask(start, middle);
                AddTask AddTask02 = new AddTask(middle, end);
                AddTask01.fork();
                AddTask02.fork();
                return AddTask01.join() + AddTask02.join();

            }
        }

    }

    public static void main(String[] args) throws IOException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        AddTask task = new AddTask(0, nums.length);
        forkJoinPool.execute(task);
        long result = task.join();
        System.out.println(result);
        System.in.read();
    }

    ;
}
