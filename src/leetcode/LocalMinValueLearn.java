package leetcode;

import leetcode.util.BaseUtil;


/**
 * @program: ThreadLearn
 * @description: 局部追销问题 ， 二分法，相邻两个元素不相等
 * @author: liuhao
 * @date: 2022-06-08 06:29
 */
public class LocalMinValueLearn {
    // 无序列数组，相邻两个元素不相等 返回任意一个局部最小
    public static void main(String[] args) {
        while (true) {
            int arrLength = 10;
            int maxValue = 100;
            int[] arr = randomNotOrderArr(arrLength, maxValue);
            boolean checkResult = checkArrar(arr);
            // System.out.println(checkResult);
            // 获取局部最小值
            int index = checkMinValue(arr);
            boolean checkResult2 = checkArrar(arr, index);
            if (checkResult2) {
                System.out.println(checkResult2);
                BaseUtil.print(arr);
                System.out.println("length : " + arr.length + "index: " + index + " value " + arr[index]);
                if (index > 0) {
                    System.out.println("left index " + arr[index - 1]);
                }
                if (index < arr.length - 1) {
                    System.out.println("right index " + arr[index + 1]);
                }
                break;
            }

        }
    }

    private static boolean checkArrar(int[] arrs, int index) {
        if (arrs.length == 0) {
            return false;
        }
        int leftIndex = index - 1;
        int rightIndex = index + 1;
        boolean leftResult = leftIndex >= 0 ? arrs[leftIndex] > arrs[index] : true;
        boolean rightResult = rightIndex < arrs.length ? arrs[rightIndex] > arrs[index] : true;
        return leftResult && rightResult;
    }

    private static int checkMinValue(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int length = arr.length;
        if (length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[length - 1] < arr[length - 2]) {
            return length - 1;
        }

        int L = 0;
        int R = length - 1;
        // 至少有3个数
        while (L < R - 1) {
            int index = (R + L) / 2;
            int indValue = arr[index];
            // 小于左边 ，小于右边
            if (arr[index - 1] > indValue && arr[index + 1] > indValue) {
                return index;
            } else {
                // 当前index 大于左边 拿左侧数据做边界index
                if (arr[index - 1] < arr[index]) {
                    R = index - 1;
                } else {
                    // index <= index -1  拿index 做右边界
                    L = index;
                }
            }
        }

        // 边界情况下,只有两个数，最小
        return arr[L] < arr[R] ? L : R;


    }

    private static boolean checkArrar(int[] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            if (arrs[i - 1] == arrs[i]) {
                System.out.println("相邻数据相等的索引" + i);
                return true;
            }
        }
        return false;
    }

    private static int[] randomNotOrderArr(int arrLength, int maxValue) {

        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue);
            } while (i > 0 && arr[i - 1] == arr[i]);
        }

        return arr;
    }


}
