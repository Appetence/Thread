package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: Thread
 * @description: 相邻必不相等，求最小值
 * @author: liuhao
 * @date: 2022-06-23 19:49
 */
public class BinarySearchLearn1 {
    public static void main(String[] args) {

        // 无序数组，相邻元素不相同 取任意区间内最小值

        // 空数组判断，元素个数小于2

        int[] arr = randomArr(10000);
        /*boolean checkResult = checkArr(arr);
        System.out.println(checkResult);*/
//        printArr(arr);

        int result = getAreaMinValue(arr);


    }

    private static boolean checkArr(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int beforIdx = i - 1;
            int idx = i;
            if (arr[beforIdx] == arr[idx]) {
                System.out.println("数组连续数据相同" + beforIdx +" >>" + idx);
                return false;
            }
        }
        return true;
    }

    private static int[] randomArr(int i) {
        int[] arr = new int[i];

        for (int idx = 0; idx < i; idx++) {
            int value;
            do {
                value = (int) (Math.random() * i);
            }
            while (idx - 1 >= 0 && arr[idx - 1] == value);
            arr[idx] = value;
        }

        return arr;

    }

    private static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(item -> System.out.println(item));
    }

    private static int getAreaMinValue(int[] arr) {

        // 边界条件判断  0 < 1   0     n-1 < n-2  n - 1

        if (arr == null || arr.length <= 1) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return arr[0];
        }
        int N = arr.length;
        if (arr[N - 1] < arr[N - 2]) {
            return arr[N - 1];
        }
        int L = 0;
        int R = arr.length - 1;

        while (L < R - 1) { // 避免后续运算减到最后只剩一个元素的情况
            int ans = (L + R) / 2;
            if (arr[ans - 1] < arr[ans] && arr[ans] < arr[ans + 1]) {
                return ans;
            }

            if (arr[L] < arr[ans]) {
                // 左侧小
                L = ans + 1;
            } else {
                // 右侧小
                R = ans - 1;
            }
        }
        // 遍历到最后，L = R -1 仅余下两个相邻元素，小于 取左边 否则取右边
        return arr[L] < arr[R] ? L : R;


    }
}
