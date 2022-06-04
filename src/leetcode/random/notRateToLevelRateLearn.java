package leetcode.random;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-05-30 10:21
 */
public class notRateToLevelRateLearn {
    /**
     * 不等概率的两个随机数 -》 等概率的两个随机数
     */

    public static void main(String[] args) {
        int [] arr = {0,0};
        for (int i = 0; i < 1000000; i++) {
            int y = y();
            int i1 = arr[y];
            arr[y] = i1 + 1;
        }

        for (int i : arr) {
            System.out.print(i+ ",");
        }

    }

    public static int x() {
        return Math.random() < 0.88 ? 0 : 1;
    }

    public static int y() {

        int ans ;
        do {
            ans = x();
            // 仅只有两次不相同时候才结束
        } while (ans == x());
        return ans;
    }
}
