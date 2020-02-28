package other;

/**
 * 位运算 计算2的幂数
 */
public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(32));
        System.out.println(isPowerOf2(19));

        System.out.println(isPowerOf2_1(32));
        System.out.println(isPowerOf2_1(19));
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
            //左移一位，各二进位全部左移若干位，高位丢弃，低位补0,左移：<< 右移：>>
            temp = temp << 1;
            //System.out.println(temp);
        }
        return false;
    }

    private static boolean isPowerOf2_1(int num) {
        return (num & num - 1) == 0;
    }

}
