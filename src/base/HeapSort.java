package base;

import java.util.Arrays;

/**
 * ������demo zzl
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {9, 2, 4, 6, 5, 7, 3, 8, 1};
        //sort(arr);
        //System.out.println(Arrays.toString(arr));
        int[] arr1 = {9, 2, 4, 6, 5, 7, 3, 8, 1};
        sortXiao(arr1);
        System.out.println("====================");
        System.out.println(Arrays.toString(arr1));
    }

    public static void sort(int[] arr) {
        //1.�����󶥶�
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //�ӵ�һ����Ҷ�ӽ��������ϣ�������������ṹ
            adjustHeap(arr, i, arr.length);
        }
        //2.�����ѽṹ+�����Ѷ�Ԫ����ĩβԪ��
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//���Ѷ�Ԫ����ĩβԪ�ؽ��н���
            adjustHeap(arr, 0, j);//���¶Զѽ��е���
        }
    }

    /**
     * ����
     * @param arr
     */
    public static void sortXiao(int[] arr) {
        //1.����С����
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //�ӵ�һ����Ҷ�ӽ��������ϣ�������������ṹ
            adjustHeapXiao(arr, i, arr.length);
        }
        System.out.println((Arrays.toString(arr)));

        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//�ѵ�һ�������һ����һ�£���С�Ļ������
            adjustHeapXiao(arr, 0, j);//���¶Զѽ��е���
        }

    }

    /**
     * С����
     *
     * @param arr
     * @param i
     * @param length
     */
    private static void adjustHeapXiao(int[] arr, int i, int length) {
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] > arr[k + 1]) {
                k++;
            }
            if (arr[k] < arr[i]) {
                swap(arr, i, k);
                i = k;
            } else {
                break;
            }
        }
    }

    /**
     * �����󶥶ѣ����ǵ������̣������ڴ󶥶��ѹ����Ļ����ϣ�
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//��ȡ����ǰԪ��i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//��i�������ӽ�㿪ʼ��Ҳ����2i+1����ʼ
            if (k + 1 < length && arr[k] < arr[k + 1]) {//������ӽ��С�����ӽ�㣬kָ�����ӽ��
                k++;
            }
            if (arr[k] > temp) {//����ӽڵ���ڸ��ڵ㣬���ӽڵ�ֵ�������ڵ㣨���ý��н�����
                //arr[i] = arr[k];
                swap(arr, i, k);//���н���
                i = k;
            } else {
                break;
            }
        }
        // arr[i] = temp;//��tempֵ�ŵ����յ�λ��
    }

    /**
     * ����Ԫ��
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}