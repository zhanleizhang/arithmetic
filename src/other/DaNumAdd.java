package other;

public class DaNumAdd {
    public static void main(String[] args) {
        String a = "1234567800000243545656";
        String b = "12345678";
        System.out.println(addNum(a, b));
        System.out.println(add(a,b));
        System.out.println(12345678 + 243545656);


    }

    private static String addNum(String a, String b) {
        int max = a.length() > b.length() ? a.length() : b.length();
        int[] temp = new int[max + 1];
        char[] charsa = a.toCharArray();
        char[] charsb = b.toCharArray();
        int i, j,n=0;
        Integer tem1 = 0;
        for (i = charsa.length - 1, j = charsb.length - 1; i >= 0 && j >= 0; i--, j--) {
            Integer tem = Integer.parseInt(String.valueOf(charsa[i])) + Integer.parseInt(String.valueOf(charsb[j]));
            Integer tem2 = tem % 10;
            temp[n++] = tem2 + tem1;
            tem1 = tem / 10;

        }
        if (i >= 0) {
            temp[n++] = Integer.parseInt(String.valueOf(charsa[i])) + tem1;
            i--;
            while (i >=0) {
                temp[n++] = Integer.parseInt(String.valueOf(charsa[i]));
                i--;
            }
        }

        if (j >= 0) {
            temp[j] = Integer.parseInt(String.valueOf(charsb[j])) + tem1;
            j--;
            while (j >= 0) {
                temp[n++] = Integer.parseInt(String.valueOf(charsb[j]));
                j--;
            }
        }
        for (int k = 0; k < temp.length; k++) {
            System.out.print(temp[k]+" ");
        }
        System.out.println();
        StringBuilder stringBuilder = new StringBuilder("");
        for (int m = temp.length-1; m >= 0; m--) {
            if (m == temp.length-1 && temp[m] == 0)
                continue;
            stringBuilder.append(temp[m] + "");
        }
        return stringBuilder.toString();
    }


    private static String add(String str1, String str2) {
        //�κ�һ���ַ���Ϊnull����ַ�����������Ҫ�����
        if (str1 == null || "".equals(str1)) {
            return str2;
        }
        if (str2 == null || "".equals(str2)) {
            return str1;
        }
        int maxLength = Math.max(str1.length(), str2.length());
        //����һ������������ַ���������Ҫ����󳤶��ַ�������һλ�����ڴ洢���ܳ��ֵĽ�λ
        StringBuffer result = new StringBuffer(maxLength + 1);

        //��ת�����ַ���
        str1 = new StringBuffer(str1).reverse().toString();
        str2 = new StringBuffer(str2).reverse().toString();

        //��ת��Ľ���ֱ�Ϊ��
        int minLength = Math.min(str1.length(), str2.length());
        //��λ
        int carry = 0;
        //��ǰλ�ϵ���ֵ
        int currentNum = 0;
        //ѭ������
        int i = 0;
        for (; i < minLength; i++) {
            //�ֱ��ȡ�����ַ���Ӧ��������ֵ��Ȼ����ӣ��ټ��Ͻ�λ
            currentNum = str1.charAt(i) + str2.charAt(i) - 2 * '0' + carry;
            //��ȡ��λ
            carry = currentNum / 10;
            //����ǰλ������ֵ
            currentNum %= 10;
            //���浱ǰλ��ֵ�����յ��ַ���������
            result.append(String.valueOf(currentNum));
        }
        if (str1.length() < str2.length()) {
            //ѡ��
            str1 = str2;
        }
        for (; i < str1.length(); i++) {
            //�ֱ��ȡ�����ַ���Ӧ��������ֵ��Ȼ����ӣ��ټ��Ͻ�λ
            currentNum = str1.charAt(i) - '0' + carry;
            //��ȡ��λ
            carry = currentNum / 10;
            //����ǰλ������ֵ
            currentNum %= 10;
            //���浱ǰλ��ֵ�����յ��ַ���������
            result.append(String.valueOf(currentNum));
        }
        //�������һ���Ľ�λ(��ѭ���������ǲ��ǻ����ܻ���һ����λ)
        if (carry > 0) {
            result.append(String.valueOf(carry));
        }
        //���ת�ָ��ַ������ٷ���
        return result.reverse().toString();
    }
}
