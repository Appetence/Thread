package leetcode.base;

import leetcode.util.BaseUtil;

/**
 * @program: ThreadLearn
 * @description: 选择排序
 * @author: liuhao
 * @date: 2022-05-27 08:33
 */
public class SelectOrderLearn {
    public static void main(String[] args) {
        // 从前到后 从小到大，依次排序
        int[] baseArr = BaseUtil.baseArr;

        selectOrder(baseArr);


    }

    // 选择排序，先选择后交换，减少交换次数， 每次外循环只交换一次
    private static void selectOrder(int[] baseArr) {
        if (baseArr == null || baseArr.length < 2) {
            return;
        }
        int maxIdx = baseArr.length;
        for (int idx = 0; idx < maxIdx; idx++) {
            int minIdx = idx;
            // 先遍历，后交换
            for (int per = idx + 1; per < maxIdx; per++) {
                if (baseArr[minIdx] > baseArr[per]) {
                    minIdx = per;
                }
            }
            BaseUtil.swap(baseArr, idx, minIdx);
        }
        BaseUtil.print(baseArr);
    }


}

