package other;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    static List<List<Integer>> lists = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {

        List<Integer> list = new ArrayList<>();
        if (nums.length == 0 || nums == null) {
            return lists;
        }
        permute(nums, list, 0);
        return lists;
    }

    private static void permute(int[] nums, List<Integer> list, int index) {
        //�߽�ֵ�ж�
        if (index == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        //i�Ǵӿ�ʼ i=index ;swap(,i)index�൱�ڹ̶���ǰλ�ã��ڽ�����һλ�����С�
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);   //��һ�ν�������֮���
            list.add(nums[index]); //���ҵ��ļӽ�ȥ
            permute(nums, list, index + 1); //���еݹ�
            list.remove(list.size() - 1); //���ж�λ�������Ҫ�����������
            swap(nums, index, i); //���ǽ�������ģ�Ҳ�������·�����һ�����н���

        }

    }

    private static void swap(int[] nums, int index, int i) {
        int t = nums[index];
        nums[index] = nums[i];
        nums[i] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> lists = new ArrayList<>();
        lists = permute(nums);
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}