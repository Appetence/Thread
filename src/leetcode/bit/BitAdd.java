package leetcode.bit;

/**
 * @program: Thread
 * @description: 二进制标识加法
 * @author: liuhao
 * @date: 2022-07-05 13:41
 */
public class BitAdd {
    public static void main(String[] args) {

        int a = 11;// 0000 1011
        int b = 0; // 0000 1001
        int add = add(a, b); // a ^ b = 0000 0010    a & b 0000 1001  << 1 0001 0010
//        int add = sub(a, b); // a ^ b = 0000 0010    a & b 0000 1001  << 1 0001 0010
        System.out.println(add);
        // multi
        b = -1;
        int mul = mul(a, b);
        System.out.println(mul);


    }

    private static int add(int a, int b) {
        int sum = a;
        while (b != 0) {  // 直到进位信息为 0  则结束返回最终结果
            // 无进位相加， 当前位置相等，则进一位，当前位置用0 来代替 ；表示非进位信息
            sum = a ^ b;
            // 进位 左移  当前位置相等则保留，最后左移一位；表示进位信息
            b = (a & b) << 1;
            a = sum;
        }
        return sum;


    }

    private static int sub(int a, int b) {
        // a- b = a + (-b ) = a + (~b + 1)
        // 负数，二进制，用补码表示
        return add(a, add(~b, 1));
    }

    private static int mul(int a, int b) {
        // a * b  = 11  * 9 = 99 = 0000 1011   +  0101 1000
        /**
         * a  0000 1011
         * b  0000 1001
         *  0000  1011
         *  0101  1000
         *
         *  0110  0011
         *
         */
        int res = 0;

        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(a ,res);
            }
            // 确保相加数据移动指定位数
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    private static int div(int a, int b) {
        //

        return 1;
    }
}
