package other;

/**
 * 位运算 计算2的幂数
 */
public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(32));
        System.out.println(isPowerOf2(19));
    }

    private static boolean isPowerOf2(int num) {
        if (num == 0) {
            return false;
        }
        int temp = 1;
        while (temp <= num) {
            if (temp == num) {
                return true;
            }
            temp = temp << 1;
        }
        return false;
    }
}
