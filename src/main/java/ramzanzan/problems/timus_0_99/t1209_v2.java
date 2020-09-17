package ramzanzan.problems.timus_0_99;

import java.util.Scanner;
import java.util.StringJoiner;

public strictfp class t1209_v2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringJoiner sj = new StringJoiner(" ");
        for(int i=0;i<n;i++) {
            long num = sc.nextInt();
            long tst = (long) (Math.sqrt((num-1)*8+1)+0.5);
            if(((num-1)*8+1)==tst*tst)
                sj.add("1");
            else
                sj.add("0");
        }
        System.out.print(sj.toString());
    }
}
//16
//1
//2
//3
//4
//5
//6
//7
//8
//9
//10
//11
//15
//16
//17