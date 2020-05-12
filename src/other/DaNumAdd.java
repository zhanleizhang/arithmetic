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
        //任何一个字符串为null或空字符串，都不需要相加了
        if (str1 == null || "".equals(str1)) {
            return str2;
        }
        if (str2 == null || "".equals(str2)) {
            return str1;
        }
        int maxLength = Math.max(str1.length(), str2.length());
        //定义一个存贮结果的字符串，长度要比最大长度字符串还长一位，用于存储可能出现的进位
        StringBuffer result = new StringBuffer(maxLength + 1);

        //翻转两个字符串
        str1 = new StringBuffer(str1).reverse().toString();
        str2 = new StringBuffer(str2).reverse().toString();

        //反转后的结果分别为：
        int minLength = Math.min(str1.length(), str2.length());
        //进位
        int carry = 0;
        //当前位上的数值
        int currentNum = 0;
        //循环变量
        int i = 0;
        for (; i < minLength; i++) {
            //分别获取两个字符对应的字面数值，然后相加，再加上进位
            currentNum = str1.charAt(i) + str2.charAt(i) - 2 * '0' + carry;
            //获取进位
            carry = currentNum / 10;
            //处理当前位的最终值
            currentNum %= 10;
            //保存当前位的值到最终的字符缓冲区中
            result.append(String.valueOf(currentNum));
        }
        if (str1.length() < str2.length()) {
            //选择
            str1 = str2;
        }
        for (; i < str1.length(); i++) {
            //分别获取两个字符对应的字面数值，然后相加，再加上进位
            currentNum = str1.charAt(i) - '0' + carry;
            //获取进位
            carry = currentNum / 10;
            //处理当前位的最终值
            currentNum %= 10;
            //保存当前位的值到最终的字符缓冲区中
            result.append(String.valueOf(currentNum));
        }
        //处理最后一个的进位(当循环结束后，是不是还可能会有一个进位)
        if (carry > 0) {
            result.append(String.valueOf(carry));
        }
        //最后翻转恢复字符串，再返回
        return result.reverse().toString();
    }
}
