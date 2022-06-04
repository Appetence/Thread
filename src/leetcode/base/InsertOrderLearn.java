package leetcode.base;

import leetcode.util.BaseUtil;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-05-27 08:34
 */
public class InsertOrderLearn {
    public static void main(String[] args) {
//        int [] baseArr = {1,5,8,7,3,2,6};
        int[] baseArr = BaseUtil.baseArr;

        // 从左到右，在一个有序数组中插入一个新的元素保障数组有序
        // 最大index
        int maxIdx = baseArr.length;

        if (baseArr == null || baseArr.length < 2) {
            // 边界条件
            return;
        }

        // 外层遍历 从0开始，两两比较交换
        for (int endIdx = 1; endIdx < maxIdx; endIdx++) {
            // 相邻的两个元素
            for (int per = endIdx - 1; per >= 0 && baseArr[per] > baseArr[per + 1]; per--) {
                BaseUtil.swap(baseArr, per, per + 1);
            }
        }
        BaseUtil.print(baseArr);


    }


}