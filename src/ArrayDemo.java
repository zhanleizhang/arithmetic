import java.util.Arrays;

/**
 * Arrays的copyOf()方法传回的数组是新的数组对象
 * copyOf()的第二个自变量指定要建立的新数组长度，如果新数组的长度超过原数组的长度，则保留数组默认值
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = Arrays.copyOf(arr1, 5);
        int[] arr3 = Arrays.copyOf(arr1, 10);
        for(int i = 0; i < arr2.length; i++)
            System.out.print(arr2[i] + " ");
        System.out.println();
        for(int i = 0; i < arr3.length; i++)
            System.out.print(arr3[i] + " ");
    }
}
