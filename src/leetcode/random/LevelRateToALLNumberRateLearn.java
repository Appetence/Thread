package leetcode.random;

import leetcode.util.BaseUtil;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-05-30 10:33
 */
public class LevelRateToALLNumberRateLearn {

    public static void main(String[] args) {
        int y = 1, z = 20;
        int[] arr = new int[z+ 1 ];
        for (int i = 0; i < 1000000; i++) {
//            int val = g(y, z) -dif;
            int val = g(y, z);
//            System.out.println(val);
            arr[val] =  arr[val] + 1;
        }
        BaseUtil.print(arr);
    }

    /**
     * 1-x 等概率随机返回  -》 y- z等概率随机返回
     * <p>
     * 0 - 1 等概率随机返回
     * <p>
     * z 与 y 相差 k  二进制表示
     * <p>
     * 0 - k 等概率随机返回 + z
     *
     * @param y
     * @param z
     */
    private static int g(int y, int z) {
        int length = 5;
        int idx = length / 2;
        int filter;
        if (length % 2 == 0) {
            // 偶数 不操作
            filter = -1;
        } else {
            // 奇数 加 1
            idx = idx + 1;
            filter = idx ;
        }
        int k = z - y + 1;
        // 0 - k 二进制表示
        // 2 的 rate 次方
        int rate = (int) (Math.log(k) / Math.log(2));

        /*double v = Math.log(k) % Math.log(2);
        if (v != 0) {
            rate = rate + 1;
        }*/

        int i = f5(rate, length, filter, idx);
//        int resultNum = i + k;

//        return resultNum;
        return i;
    }

    private static int f5(int rate, int length, int filter, int idx) {
        int ans = 0;
        for (int i = 0; i < rate; i++) {
            int i1 = f3(length, filter, idx) << i;
            ans = ans + i1;
//            System.out.println(">>" + i1);
        }

//         ans = (f3(length, filter, idx) << 4) + (f3(length, filter, idx) << 3) + (f3(length, filter, idx) << 2 )+ (f3(length, filter, idx) << 1) + (f3(length, filter, idx) << 0);
        return ans;
    }

    private static int f3(int length, int filter, int idx) {
        int baseResult;
        do {
            // 等概率返回指定区间数据
            baseResult = f1(length);
            // 偶数OK                 奇数OK
        } while ((filter != -1) && (baseResult == filter));
        return baseResult < idx ? 0 : 1;
    }

    private static int f1(int i) {
        //1 -> i + 1
        return (int) (Math.random() * i) + 1 ;
    }


}
