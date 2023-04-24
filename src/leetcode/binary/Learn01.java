package leetcode.binary;

import leetcode.util.BaseUtil;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-08-29 08:13
 */
public class Learn01 {

    /**
     * 1 有序数组，查找某个数是否存在
     * 2 有序数组 >= 某个数最左侧的位置
     * 3 有序数组 <= 某个数最右侧的位置
     * 4 相邻不相等，局部最小值问题
     *
     * @param args
     */
    public static void main(String[] args) {
        findOwne(1);
    }

    private static boolean findOwne(int num) {
        /**
         * 二分查找
         *
         */
        // 有序数组
        int[] arr = BaseUtil.ORDER_ARRAY;
        // 先判断边界  null    长度为0             只有一个数 且不相等
        if (arr == null || arr.length == 0/* || (arr.length == 1 && arr[0] != num)*/) {
            return false;
        }
        // 长度大于等于1 单独判断长度为1 的情况
        int length = arr.length;
        int left = 0 ;
        while (length > 1){


        }

        // 兼容仅有一个的情况




        // 对数器
        return false;

    }
}
