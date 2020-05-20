package reduce;

/**
 * ��󷵻صĶ���low��
 * �����Ѱ�ҵ�һ������key�ģ���if( arr[mid] >= key) high = mid - 1�������Ҫ�ж�L�ĺϷ��Լ��Ƿ����key��
 * �����Ѱ�ҵ�һ�����ڵ���key�ģ�Ҳ��if(arr[mid] >= key) high = mid - 1���������ֱ�ӷ���low��
 * �����Ѱ�ҵ�һ������key�ģ����ж�������if(arr[mid] > key) high = mid - 1����󷵻�low ��
 */
public class BinarySearch {
    public static void main(String[] args) {
        //��һ������value��ֵ
        int[] arr = {1, 3, 4, 5, 6, 7, 9, 9, 9, 11, 18};
        int firstEqual = firstEqual(arr, arr.length, 9);
        System.out.println(firstEqual);
        int firstLargeEqual = firstLargeEqual(arr, arr.length, 10);
        System.out.println(firstLargeEqual);
        int firstLarge = firstLarge(arr, arr.length, 9);
        System.out.println(firstLarge);

        int lastEqual = lastEqual(arr, arr.length, 9);
        System.out.println(lastEqual);
        int lastSmallEqual = lastSmallEqual(arr, arr.length, 10);
        System.out.println(lastSmallEqual);
        int lastSmall = lastSmall(arr, arr.length, 9);
        System.out.println(lastSmall);


    }

    private static int firstLarge(int[] arr, int length, int value) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int firstLargeEqual(int[] arr, int length, int value) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low < length && arr[low] >= value)
            return low;
        return -1;
    }


    private static int firstEqual(int[] arr, int length, int value) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low < length && arr[low] == value)
            return low;
        return -1;
    }


    private static int lastEqual(int[] arr, int length, int value) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high < length && arr[high] == value)
            return high;
        return -1;
    }

    private static int lastSmallEqual(int[] arr, int length, int value) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high < length && arr[high] <= value)
            return high;
        return -1;
    }


    private static int lastSmall(int[] arr, int length, int value) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

}
