package base;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr1 = {3, 4, 2, 1, 9, 6, 7, 8};
        int[] arr2 = {3, 4, 2, 1, 9, 6, 7, 8};
        int[] arr3 = {3, 4, 2, 1, 9, 6, 7, 8};
        //冒泡1
        sort1(arr1);
        System.out.println(Arrays.toString(arr1));
        //冒泡2
        sort2(arr2);
        System.out.println(Arrays.toString(arr2));
        //冒泡3
        sort3(arr3);
        System.out.println(Arrays.toString(arr3));

    }

    /**
     * 基本冒泡
     *
     * @param arr
     */
    private static void sort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡优化
     *
     * @param arr
     */
    private static void sort2(int[] arr) {
        //需要遍历数组长度次数，每次找一个最大的
        for (int i = 0; i < arr.length - 1; i++) {
            Boolean isSort = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }

    /**
     * 冒泡优化
     * 把无序边界的位置改成最后交换的位置
     *
     * @param arr
     */
    private static void sort3(int[] arr) {
        int sortBorder = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            Boolean isSort = true;
            int pos = 0;
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isSort = false;
                    pos = j;
                }
            }
            if (isSort) {
                break;
            }
            sortBorder = pos;
        }
    }

}
