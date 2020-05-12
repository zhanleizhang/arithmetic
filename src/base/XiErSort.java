package base;

/**
 * Ï£¶ûÅÅĞò
 */
public class XiErSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 7, 3, 6, 9, 2, 3};
        xierSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void xierSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            gap = gap / 2;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length; j += gap) {
                    if (j + gap < arr.length && arr[j] > arr[j + gap]) {
                        swap(arr, j, j + gap);
                    }
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int k) {
        int temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }
}
