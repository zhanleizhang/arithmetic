package base;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr1 = {3, 4, 2, 1, 5, 6, 7, 8};
        int[] arr2 = {3, 4, 2, 1, 9, 6, 7, 8};

        //选大
        sort1(arr1);
        System.out.println(Arrays.toString(arr1));
        //选小
        sort2(arr2);
        System.out.println(Arrays.toString(arr2));

    }

    /**
     * 选大的
     *
     * @param arr1
     */
    private static void sort1(int[] arr1) {
        for (int i = arr1.length - 1; i > 0; i--) {
            int max = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr1[max] < arr1[j]) {
                    max = j;
                }
            }
            int tmp = arr1[i];
            arr1[i] = arr1[max];
            arr1[max] = tmp;
        }
    }

    /**
     * 选小的
     *
     * @param arr2
     */
    private static void sort2(int[] arr2) {
        for (int i = 0; i <= arr2.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr2.length; j++) {
                if (arr2[min] > arr2[j]) {
                    min = j;
                }
            }
            int tmp = arr2[i];
            arr2[i] = arr2[min];
            arr2[min] = tmp;
        }
    }
}
