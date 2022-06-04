package leetcode.base;

import leetcode.util.BaseUtil;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-05-27 09:49
 */
public class BubbleOrderLearn {
    public static void main(String[] args) {
        int[] baseArr = BaseUtil.baseArr;
//        public static int[] baseArr = {1, 5, 8, 7, 3, 2, 6};
        // 从左到右，在一个有序数组中插入一个新的元素保障数组有序
        // 最大index
        int maxIdx = baseArr.length - 1;
        bubbleSort2(maxIdx, baseArr);
        BaseUtil.print(baseArr);
    }

    private static void bubbleSort(int maxIdx, int[] baseArr) {
        // 相邻的两个元素，两两比较，交换，稳定排序
        for (int idx = maxIdx; idx >= 0; idx--) {
            for (int per = 1; per <= maxIdx; per++) {

                if (baseArr[per - 1] > baseArr[per]) {
                    BaseUtil.swap(baseArr, per - 1, per);
                }
            }
        }
    }

    private static void bubbleSort2(int maxIdx, int[] baseArr) {
        // 相邻的两个元素，两两比较，交换，稳定排序
        for (int idx = 1; idx <= maxIdx; idx++) {
            // 从最大值开始，到1结束
            for (int per = maxIdx; per >= idx; per--) {
                if (baseArr[per - 1] > baseArr[per]) {
                    BaseUtil.swap(baseArr, per - 1, per);
                }
            }
        }
    }
}