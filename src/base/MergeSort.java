package base;

import java.util.Arrays;

/**
 * 归并排序
 * 任何情况都是nlogn
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 5, 6, 7, 8};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int mids = mid + 1;
        int low = left;
        int j = 0;
        while (left <= mid && mids <= right) {
            if (arr[left] < arr[mids]) {
                tmp[j++] = arr[left++];
            } else {
                tmp[j++] = arr[mids++];
            }
        }

        while (left <= mid) {
            tmp[j++] = arr[left++];
        }
        while (mids <= right) {
            tmp[j++] = arr[mids++];
        }

        for (int i = 0; i < tmp.length; i++) {
            arr[low + i] = tmp[i];
        }

    }
}
