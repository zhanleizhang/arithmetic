package leetcode;

import java.util.Arrays;

/**
 * 字符串异位
 */
public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        String s1 = "rnagram";
        String t1 = "nagaram";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram1(s1,t1));
    }

    /**
     * 数组排序进行最终比较
     *
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * 通过计数器运算进行判断
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                return false;
        }
        return true;
    }
}
