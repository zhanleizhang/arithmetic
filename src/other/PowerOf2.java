package other;

/**
 * λ���� ����2������
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
            //����һλ��������λȫ����������λ����λ��������λ��0,���ƣ�<< ���ƣ�>>
            temp = temp << 1;
            //System.out.println(temp);
        }
        return false;
    }

    private static boolean isPowerOf2_1(int num) {
        return (num & num - 1) == 0;
    }

}
