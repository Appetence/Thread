package dataStructure.algorithm;

/**
 * @program: ThreadLearn
 * @description: 选择排序 依次在未排序的序列中找到最大（小）的元素放到起始位置，只到所有元素排序完毕
 * 获取到最小元素的为位置时候先记录索引，知道所有的元素都比较结束之后才进行交换
 * @author: liuhao
 * @create: 2020-06-29 13:11
 */
public class SelectSort {
    public static void main(String[] args) {

        //从第一个元素开始遍历数组，依次比较，如果后边的参数大于该参数，则进行交换依次进行
        int[] arr = {1, 3, 2, 5, 6, 7, 89, 0, 2};

        for (int i = 0; i < arr.length - 1; i++) {//从索引1开始依次向后遍历

            int index = i;
            for (int j = i + 1; j < arr.length; j++) {//从当前元素开始，依次向后比较，将最小的元素放到第一个
                if(arr[index] > arr[j] ){
                    index = j;
                }
            }
            swap (arr,i ,index);
        }
        print(arr);

    }

    static void swap(int[] arr, int i, int j) {
        if (arr[j] < arr[i]) {//后一个小于前一个，则交换顺序
            //定义一个变量用于零时存储数据
            int team = arr[i];
            arr[i] = arr[j];
            arr[j] = team;
        }
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
