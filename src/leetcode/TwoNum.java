package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数相加
 */
public class TwoNum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> arr = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            arr.put(nums[i], i);
        }
        for (int j = 0; j < arr.size(); j++) {
            int tmp = target - nums[j];
            if (arr.containsKey(tmp) && arr.get(tmp) != j) {
                return new int[]{j, arr.get(tmp)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int t = 9;
        int[] ints = twoSum(arr, t);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
