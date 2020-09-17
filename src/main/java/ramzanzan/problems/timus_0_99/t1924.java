package ramzanzan.problems.timus_0_99;

import java.util.Scanner;

public class t1924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(((n+1)/2)%2==1 ? "grimy" : "black");
    }
}
