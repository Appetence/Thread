package dataStructure.algorithm.quickSort;

/**
 * @program: ThreadLearn
 * @description: 快速排序 冒泡排序的优化，选择一个基准，将所有比基准小的元素放到前边，比基准大的元素放到基准后边，两边依次分别进行排序
 * @author: liuhao
 * @create: 2020-10-12 18:56
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 34, 5, 4, 22, 13, 98, 4, 9, 6};

        //从左到右和从右到左依次寻找到第一个比6大的和第一个比6小的交换
        int indexLeft = 0;
        int indexRigt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (indexLeft == 0) {
                if (arr[i] > 6) {
                    indexLeft = i;
                }
            }
            if (indexRigt == 0) {
                if (arr[arr.length - 1 - i] < 6) {
                    indexRigt = arr.length - 1 - i;
                }
            }
            if (indexLeft != 0 && indexRigt != 0) {
                int result = arr[indexLeft];
                arr[indexLeft] = arr[indexRigt];
                arr[indexRigt] = result;
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void swap(int[] arr, int indexLeft, int indexRigt) {
        int i = arr[indexLeft];
        arr[indexLeft] = arr[indexRigt];
        arr[indexRigt] = i;
    }
}
