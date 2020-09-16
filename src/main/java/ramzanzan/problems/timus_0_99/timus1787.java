package ramzanzan.problems.timus_0_99;

import java.util.Scanner;

public class timus1787 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(), n = sc.nextInt();
        int p = 0;
        for(int i=0; i<n; i++) {
            p += sc.nextInt() - k;
            if (p<0) p = 0;
        }
        System.out.print(p);
    }
}
