package reduce;

/**
 * ���ֲ���
 */
public class ReduceSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 7, 9, 9, 9, 11, 18};
        //���ҵ�һ�����ϸ���ֵ�Ե�
        int fire = bsearch2(arr, arr.length, 9);
        //System.out.println(fire);
        //�������һ�����ϸ���ֵ�Ե��±�
        int laste = bsearch3(arr, arr.length, 9);
        //System.out.println(laste);
        //���ҵ�һ�����ڵ��ڸ���ֵ��
        int firge = bsearch4(arr, arr.length, 9);
        //System.out.println(firge);
        //�������һ��С�ڵ��ڸ���ֵ��
        int lastle = bsearch5(arr, arr.length, 8);
        System.out.println(lastle);

    }

    /**
     * �������һ��С�ڵ��ڸ���ֵ��
     *
     * @param arr
     * @param length
     * @param value
     * @return
     */
    private static int bsearch5(int[] arr, int length, int value) {
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            System.out.println("***"+mid);
            if (arr[mid] <= value) {
                //  high = mid - 1;
                low = mid + 1;
            } else {
                //low = mid + 1;
                high = mid - 1;

            }
        }

        if (high < length && arr[high] <= value)
            return high;
        else
            return -1;
    }

    /**
     * ���ҵ�һ�����ڵ��ڸ���ֵ��
     *
     * @param arr
     * @param length
     * @param value
     * @return
     */
    private static int bsearch4(int[] arr, int length, int value) {
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
        else
            return -1;

    }

    /**
     * �������һ�����ϸ���ֵ�Ե��±�
     *
     * @param arr
     * @param length
     * @param value
     * @return
     */
    private static int bsearch3(int[] arr, int length, int value) {
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
        if (high < length && arr[high] == value) {
            return high;
        } else {
            return -1;
        }
    }

    /**
     * �򵥶��ֲ���
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }


    public static int bsearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (low < n && a[low] == value) return low;
        else return -1;
    }


    /**
     * ���ҵ�һ�����ϸ���ֵ���±�
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value) {
                //high = mid - 1;
                low = mid + 1;
            } else if (a[mid] > value) {
                //low = mid + 1;
                high = mid - 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

}
