package leetcode.util;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-05-27 08:35
 */
public class BaseUtil {
    public static final int[] ORDER_ARRAY = {};
    public static int[] baseArr = {1, 5, 8, 7, 3, 2, 6};
    public static int[] levelRateArr = {1, 2, 3, 4, 5};

    public static void swap(int[] baseArr, int before, int last) {
        int length = baseArr.length;
        if (length > before && length > last) {
            int item = baseArr[before];
            baseArr[before] = baseArr[last];
            baseArr[last] = item;
        }
    }

    public static void print(int[] baseArr) {
        if (baseArr != null) {
            int length = baseArr.length;
            for (int idx = 0; idx < length; idx++) {
                System.out.print(baseArr[idx] + ",");
            }
        }
    }

}
