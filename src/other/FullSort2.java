package other;

import java.util.ArrayList;
import java.util.List;

/**
 * ȫ����
 */
public class FullSort2 {

    // ���շ��صĽ����
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0 || nums == null) return res;

        // ����ǰ��Ԫ�ؽ����İ취��dfs����
        exchange(nums, 0, len);
        return res;
    }

    public void exchange(int[] nums, int i, int len) {
        // ����ǰ����ӵ��������
        if (i == len - 1) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                list.add(nums[j]);
            }
            res.add(list);
            return;
        }
        // ����ǰλ�õ��������������������������
        for (int j = i; j < len; j++) {
            swap(nums, i, j);
            exchange(nums, i + 1, len);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 7,3, 4};
       /* FullSort2 fullSort2 = new FullSort2();
        List<List<Integer>> lists = fullSort2.permute(arr);*/
        for (int i : arr) {
            System.out.println(i);
        }
    }
}