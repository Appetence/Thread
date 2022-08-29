package learn;

/**
 * @program: Thread
 * @description:
 * @author: liuhao
 * @date: 2022-06-15 17:54
 */
public class A {

    public static void main(String[] args) {
        int n = 7;
        n = 11;
        /*// 0111  | 0011
        n |= n >>> 1;
        // 0111  | 0001
        n |= n >>> 2;
        // 0111  | 0000
        n |= n >>> 4;
        // 0111  | 0000
        n |= n >>> 8;
        // 0111  | 0000
        n |= n >>> 16;
        // 1000     1 0000*/
        n = (n + 1) << 1;
        // 1001   1 0010
        System.out.println(n);
    }
}
