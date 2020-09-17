package ramzanzan.problems.timus_0_99;

import java.util.Scanner;

public class t1639 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        System.out.print((m%2==1 && n%2==1)? "[second]=:]" : "[:=[first]");
    }
}