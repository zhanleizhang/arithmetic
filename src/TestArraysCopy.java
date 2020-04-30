import java.util.Arrays;

public class TestArraysCopy {
    public static void main(String[] args) {
        int[] a1 = new int[] {1, 2, 3, 4};
        Num[] a2 = new Num[] {new Num(1), new Num(2), new Num(3), new Num(4)};
        
        int[] c1 = Arrays.copyOf(a1, a1.length);
        Num[] c2 = Arrays.copyOf(a2, a2.length);

        System.out.println("a1: " + a1[0] + " c1: " + c1[0]);//a1: 1 c1: 0
        System.out.println("a2: " + a2[0].num + " c2: " + c2[0].num);//a2: 0 c2: 0
        
        c1[0] = 0;
        c2[0].num = 0;
        
        System.out.println("a1: " + a1[0] + " c1: " + c1[0]);//a1: 1 c1: 0
        System.out.println("a2: " + a2[0].num + " c2: " + c2[0].num);//a2: 0 c2: 0
    }
}

class Num{
    int num;
    
    public Num(int num) {
        this.num = num;
    }
}