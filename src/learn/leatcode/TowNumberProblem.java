package learn.leatcode;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2021-11-15 20:46
 */
public class TowNumberProblem {

    public static void main(String[] args) {
        int divided = 0;
        int divisor = 0;
        int result = divide(divided, divisor);
    }
//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
// 返回被除数 dividend 除以除数 divisor 得到的商。
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
//
//
//
// 示例 1:
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
//
// 示例 2:
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2
//
//
//
// 提示：
//
//
// 被除数和除数均为 32 位有符号整数。
// 除数不为 0。
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
//
// Related Topics 位运算 数学
// 👍 763 👎 0


    private static int divide(int divided, int divisor) {
        //
        //
        if (divided == 0) {
            return 0;
        }
        if (divided == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        Boolean a;
        a = (divided ^ divisor) < 0;   //转为异或进行计算，因为负数首置位为1

        long t = Math.abs((long) divided);  //abs绝对值即为正数
        long s = Math.abs((long) divisor);
        int re = 0;

        for (int i = 31; i >= 0; i--) {   //从大到小
            if (t >> i >= s) {   //从31--开始进行右移位计算  例如t=10，s=2，解法为10／10（8，7，6，5，4，3，2，1）等等，最后舍弃余数
                //只取正数
                re += 1 << i;//将结果加上2^n
                t -= s << i;//将被除数减去2^n*divisor
            }
        }
        return a ? -re : re;


    }
}
