package dp;

import java.util.Arrays;

/**
 * 动态规划
 */
public class DpMain {
    public static void main(String[] args) {
        System.out.println(fn(7));
        System.out.println(fn1(7));
        System.out.println(fn2(7));
        //凑零钱
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
        System.out.println(coinChange1(coins, 15));
        System.out.println(coinChange2(coins, 34));
        //最长子序列，不是子串
        int[] str = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(subStringLength(str));
    }

    /**
     * 递归算法
     *
     * @param i
     * @return
     */
    private static Integer fn(int i) {
        if (i == 1 || i == 2)
            return 1;
        return fn(i - 1) + fn(i - 2);
    }

    /**
     * 备忘录
     *
     * @param i
     * @return
     */
    private static Integer fn1(int i) {
        int temp1 = 1;
        int temp2 = 1;
        int m = 3;
        int temp = 2;
        while (m <= i) {
            temp = temp1 + temp2;
            temp1 = temp2;
            temp2 = temp;
            m++;
        }
        return temp;
    }

    /**
     * 动态规划
     *
     * @param i
     * @return
     */
    private static Integer fn2(int i) {
        int[] dp = new int[i + 1];
        dp[1] = 1;
        dp[2] = 1;
        int j;
        for (j = 3; j <= i; j++) {
            dp[j] = dp[j - 1] + dp[j - 2];
        }
        return dp[i];
    }

    private static int coinChange(int[] coins, int account) {
        if (account == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (account - coins[i] < 0) continue;
            int subPro = coinChange(coins, account - coins[i]);
            if (subPro == -1) continue;
            ans = Math.min(ans, subPro + 1);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static int coinChange1(int[] coins, int account) {
        int[] count = new int[account + 1];
        for (int i = 0; i < account + 1; i++) {
            count[i] = -2;
        }
        return coinCount(coins, account, count);
    }

    private static int coinCount(int[] coins, int account, int[] count) {
        if (account == 0) return 0;
        if (count[account] != -2) return count[account];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (account - coins[i] < 0) continue;
            int subPro = coinCount(coins, account - coins[i], count);
            if (subPro == -1) continue;
            ans = Math.min(ans, subPro + 1);
        }
        count[account] = ans == Integer.MAX_VALUE ? -1 : ans;
        return count[account];
    }

    private static int coinChange2(int[] coins, int account) {

        int[] dp = new int[account + 1];
        //设置成最大值好和后面的最小值进行比较
        for (int i = 0; i < account + 1; i++) {
            dp[i] = account + 1;
        }
        //填充数组初始化为account+1
        //Arrays.fill(dp,account+1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[account] == account + 1 ? -1 : dp[account];
    }



    /**
     * {10,9,2,5,3,7,101,18}    2,3,7,101
     * @param arr
     * @return
     */
    private static int subStringLength(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
//1 1 2 3 5 8 13
