package ramzanzan.problems.timus_0_99;

import java.util.Scanner;

public class timus2066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(), n2 = sc.nextInt();
        if(n1>n2){
            n1^=n2;
            n2^=n1;
            n1^=n2;
        }
        int n3 = sc.nextInt();
        if(n2>n3){
            n3^=n2;
            n2^=n3;
            n3^=n2;
            if(n1>n2){
                n1^=n2;
                n2^=n1;
                n1^=n2;
            }
        }
        int p2;
        switch (n2){
            case 0: p2=n3; break;
            case 1: p2=n2+n3; break;
            default: p2=n2*n3;  break;
        }
        System.out.print(n1-p2);
    }
}
