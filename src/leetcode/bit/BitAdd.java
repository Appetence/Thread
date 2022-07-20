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
        b = 3;
        int div = div(a, b);
        System.out.println(div);


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
                res = add(a, res);
            }
            // 确保相加数据移动指定位数
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    protected static int divid(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)) {
                // 系统最小除以 -1 系统最大
                return Integer.MAX_VALUE;
            } else {
                /**
                 * ( a + 1 ) / b = c
                 * d = a - (c * b)
                 * e = d / b
                 * result = c + e
                 */
                int ans = div(add(a, 1), b);
                return add(ans, div(sub(a, mul(ans, b)), b));
            }
        } else {
            return div(a, b);
        }

    }

    /**
     * 存在系统最小值问题
     *
     * @param a
     * @param b
     * @return
     */
    private static int div(int a, int b) {
        /**
         * a / b = c
         * c * b = a
         * a >>    与  b  比较避免存在超过符号位的情况
         */
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        // x / y
        int res = 0;
        for (int i = 30; i >= 0; i = sub(i, 1)) {
            if ((x >> i) >= y) {// 由于偏移为向右，从大到小，所以判断大于等于 y 的情况,便于后边相减少
                res |= (1 << i); // 汇总
                x = sub(x, y << i); // y * 2 ^ i 次方
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    /**
     * 取反
     * @param n
     * @return
     */
    private static int negNum(int n) {
        return add(~n , 1);
    }

    private static boolean isNeg(int b) {
        return b < 0;
    }
}
