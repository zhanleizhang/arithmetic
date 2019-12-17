package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class Intersection {
    public static void main(String[] args) {
        int[] num1 = new int[]{4, 9, 5};
        int[] num2 = new int[]{8, 4, 9, 9};
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer n : num1) {
            set1.add(n);
        }
        for (Integer m : num2) {
            set2.add(m);
        }

        if (set1.size() > set2.size())
            System.out.println(Arrays.toString(intersection(set1, set2)));
        else
            System.out.println(Arrays.toString(intersection(set2, set1)));
    }

    private static int[] intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] arr = new int[set2.size()];
        int idx = 0;
        for (Integer m : set2) {
            if (set1.contains(m))
                arr[idx++] = m;
        }
        return Arrays.copyOf(arr, idx);
    }
}
