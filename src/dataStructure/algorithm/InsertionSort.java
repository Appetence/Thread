package dataStructure.algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: ThreadLearn
 * @description: 插入排序（适用于数据量较小的情况），在一个排好顺序的数组中插入一个元素使得整个数组呈现为有序数组
 * 从一个无序队列中依次拿出一个元素，跟有序队列中的数据对比，确定其位置
 * @author: liuhao
 * @create: 2020-07-07 13:19
 */
public class InsertionSort {
    //最好时间复杂度n 平均时间复杂度为n^2
    public static void main(String[] args) {
        int[] arrays = {1, 3, 5, 6, 2, 4, 9, 8, 9};

        swapOptimize(arrays);

        print(arrays);
    }

    //传统方式
    static void swap(int[] arrays) {
        //首先遍历数组，依次获取数组中每一个元素
        for (int i = 0; i < arrays.length; i++) {

            //从索引i开始，到索引0结束依次递减，对i前面的数组进行从小到达的排序
            for (int j = 0; j < i; j++) {
                if (arrays[j] > arrays[i]) {//依次比较当前元素与插入元素的大小
                    int team = arrays[j];
                    arrays[j] = arrays[i];
                    arrays[i] = team;
                }
            }


        }
    }

    //方法二
    static void swap2(int[] arrays) {
        //首先遍历数组，依次获取数组中每一个元素
        for (int i = 0; i < arrays.length; i++) {

            //从索引i开始，到索引0结束依次递减，对i前面的数组进行从小到达的排序
            for (int j = i; j > 0; j--) {
                if (arrays[j - 1] > arrays[j]) {//依次比较当前元素与插入元素的大小
                    int team = arrays[j];
                    arrays[j] = arrays[j - 1];
                    arrays[j - 1] = team;
                }
            }


        }
    }

    //优化后
    static void swapOptimize(int[] arrays) {
        //首先遍历数组，依次获取数组中每一个元素
        for (int i = 0; i < arrays.length; i++) {

            //从索引i开始，到索引0结束依次递减，对i前面的数组进行从小到达的排序
            for (int j = i; j > 0; j--) {
                if (arrays[j - 1] > arrays[j]) {//依次比较当前元素与插入元素的大小
                    int team = arrays[j];
                    arrays[j] = arrays[j - 1];
                    arrays[j - 1] = team;
                }
            }


        }
    }

    static void print(int[] arrays) {
        Arrays.stream(arrays).forEach(System.out::println);
    }
}

