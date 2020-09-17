package ramzanzan.problems.timus_0_99;

import java.util.Scanner;

public class t1910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max, id=3, l, c, r, cur;
        max = (l=sc.nextInt()) + (c=sc.nextInt()) + (r=sc.nextInt());
        cur = max;
        for(int i=4;i<=n;i++){
            cur-=l;
            l=c;
            c=r;
            cur+=(r=sc.nextInt());
            if(max<cur){
                max=cur;
                id=i;
            }
        }
        System.out.print(max+" "+(id-1));
    }
}
