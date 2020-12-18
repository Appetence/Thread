package dataStructure.algorithm;

/**
 * @program: ThreadLearn
 * @description: 冒泡排序 从第一一个元素开始向后边两两依次比较，从大到小依次排列  从前到后 依次两两比较
 *               冒泡排序和选择排序，每次确定数据位置后不会在变化
 * @author: liuhao
 * @create: 2020-07-14 15:14
 */
public class BubbleSort {
    public static void main(String[] args) {
        //依次遍历，两两比较，将最小的放到最后边

        int[] arr = {1, 5, 3, 6, 9, 2, 4, 8};
        //第几个位置
        for (int i = 0; i < arr.length; i++) {
            //从第几个元素开始
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int var = arr[i];
                    arr[i] = arr[j];
                    arr[j] = var;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
