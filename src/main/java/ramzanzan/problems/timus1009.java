package ramzanzan.problems;

import java.util.Scanner;

public class timus1009 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        long naturalEnd = k*k-k -(k-1);
        long zeroEnd = k-1;
        if(n==2) {
            System.out.println(naturalEnd+zeroEnd);
            return;
        }

        for(int i=2; i<n;++i){
            long tmp = zeroEnd;
            zeroEnd = naturalEnd;
            naturalEnd = naturalEnd*(k-1) + tmp*(k-1);
        }
        System.out.println(naturalEnd+zeroEnd);
    }
}
