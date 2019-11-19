package base;

import java.util.Arrays;

/**
 * ���� ���η�
 * ƽ��ʱ�临�Ӷ���nlogn,���n*n
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
        //���û�׼ֵ
        int tmp = arr[left];
        while (left < right) {
            while (left < right && arr[right] > tmp) {
                right--;
            }
            //�Ȱ��ұߵ�ֵ��ֵ��low,right�ճ�
            arr[left] = arr[right];
            while (left < right && arr[left] < tmp) {
                left++;
            }
            //����ߵ�ֵ��ֵ��right,left�ճ�
            arr[right] = arr[left];

        }
        //�ѻ�׼ֵ�����ճ���left
        arr[left] = tmp;
        return left;
    }

}
