package other;

public class DaNumAdd {
    public static void main(String[] args) {
        String a = "12345678";
        String b = "12345678";
        System.out.println(addNum(a, b));
        System.out.println(12345678 + 12345678);


    }

    private static String addNum(String a, String b) {
        int max = a.length() > b.length() ? a.length() : b.length();
        int[] temp = new int[max + 1];
        char[] charsa = a.toCharArray();
        char[] charsb = b.toCharArray();
        int i, j;
        Integer tem1 = 0;
        for (i = charsa.length - 1, j = charsb.length - 1; i >= 0 && j >= 0; i--, j--) {
            Integer tem = Integer.parseInt(String.valueOf(charsa[i])) + Integer.parseInt(String.valueOf(charsb[i]));
            Integer tem2 = tem % 10;
            temp[i] = tem2 + tem1;
            tem1 = tem / 10;

        }
        if (i > 0) {
            temp[i] = Integer.parseInt(String.valueOf(charsa[i])) + tem1;
            i--;
            while (i > 0) {
                temp[i] = Integer.parseInt(String.valueOf(charsa[i]));
            }
        }

        if (j > 0) {
            temp[j] = Integer.parseInt(String.valueOf(charsa[j])) + tem1;
            j--;
            while (j > 0) {
                temp[j] = Integer.parseInt(String.valueOf(charsa[j]));
            }
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (int m = 0; m < temp.length; m++) {
            if (m == temp.length - 1 && temp[m] == 0)
                continue;
            stringBuilder.append(temp[m] + "");
        }
        return stringBuilder.toString();
    }
}
