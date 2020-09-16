package ramzanzan.problems.timus_0_99;

import java.util.Scanner;

public class timus2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt(), b1 = sc.nextInt(),
                a2 = sc.nextInt(), b2 = sc.nextInt(),
                a3 = sc.nextInt();
        System.out.print((b1-b2)+" "+(a1-a3));
    }
}
