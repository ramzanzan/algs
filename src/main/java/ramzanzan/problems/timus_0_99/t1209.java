package ramzanzan.problems.timus_0_99;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class t1209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        long max = 0;
        for(int i=0;i<n;i++) {
            a[i] = sc.nextInt();
            if (a[i] > max) max = a[i];
        }
        int[] poses = new int[(int)Math.ceil(Math.sqrt(max*2L))];
        poses[0]=1;
        for(int i=1;i<poses.length;i++)
            poses[i]=poses[i-1]+i;
        StringJoiner sj = new StringJoiner(" ");
        for(int num : a)
            sj.add(Arrays.binarySearch(poses,num)<0 ? "0" : "1");
        System.out.print(sj.toString());
    }
}
