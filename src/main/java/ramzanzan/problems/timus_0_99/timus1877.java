package ramzanzan.problems.timus_0_99;

import java.util.Scanner;

public class timus1877 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l1 = sc.nextInt(), l2 = sc.nextInt();
        System.out.print(l1%2==0 || l2%2==1 ? "yes" : "no");
    }
}
