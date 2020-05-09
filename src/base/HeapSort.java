package base;

import java.util.Arrays;

/**
 * 堆排序demo zzl
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
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }
    }

    /**
     * 降序
     * @param arr
     */
    public static void sortXiao(int[] arr) {
        //1.构建小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeapXiao(arr, i, arr.length);
        }
        System.out.println((Arrays.toString(arr)));

        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//把第一个和最后一个换一下，最小的换到最后
            adjustHeapXiao(arr, 0, j);//重新对堆进行调整
        }

    }

    /**
     * 小顶堆
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
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                //arr[i] = arr[k];
                swap(arr, i, k);//进行交换
                i = k;
            } else {
                break;
            }
        }
        // arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
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