package base;

import java.util.Arrays;

/**
 * 快排 分治法
 * 平均时间复杂度是nlogn,最坏是n*n
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 5, 6, 7, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int base = getBase(arr, left, right);
            quickSort(arr, left, base);
            quickSort(arr, base + 1, right);
        }
    }

    private static int getBase(int[] arr, int left, int right) {
        //设置基准值
        int tmp = arr[left];
        while (left < right) {
            while (left < right && arr[right] > tmp) {
                right--;
            }
            //先把右边的值赋值给low,right空出
            arr[left] = arr[right];
            while (left < right && arr[left] < tmp) {
                left++;
            }
            //把左边的值赋值给right,left空出
            arr[right] = arr[left];

        }
        //把基准值填充给空出的left
        arr[left] = tmp;
        return left;
    }

}
