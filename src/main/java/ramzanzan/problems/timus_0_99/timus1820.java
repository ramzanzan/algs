package ramzanzan.problems.timus_0_99;

import java.util.Scanner;

public class timus1820 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.print( n*2>k ? (int)Math.ceil((n*2)/(float)k) : 2);
    }
}
