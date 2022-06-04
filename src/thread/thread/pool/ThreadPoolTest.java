package thread.thread.pool;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-05-23 09:11
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
         int COUNT_BITS = Integer.SIZE - 3;
         int CAPACITY   = (1 << COUNT_BITS) - 1;
        System.out.println(CAPACITY);
        int CAPACITY_TEST = ~CAPACITY;
        System.out.println(CAPACITY_TEST);
        int result  = ~1;
        System.out.println(result);
// 1111 1111 1111 1111
// 1000 0000 0000 0000
//0000 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111
//1111 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000

    }
}
