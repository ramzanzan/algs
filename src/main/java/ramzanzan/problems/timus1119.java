package ramzanzan.problems;

import java.util.Scanner;

public class timus1119 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        double s=100, h=Math.sqrt(s*s*2);
        double[][] a = new double[n+1][m+1];
        for(int i=0;i<k;i++)
            a[sc.nextInt()][sc.nextInt()]=1;
        for(int i=0;i<=n;i++)
            for(int j=0;j<=m;j++){
                double cost = Double.POSITIVE_INFINITY;
                if(i!=0) cost = a[i-1][j]+s;
                if(j!=0 && cost>a[i][j-1]+s) cost=a[i][j-1]+s;
                if(i==0 && j==0) cost=0;
                if(a[i][j]==1 && cost>a[i-1][j-1]+h) cost=a[i-1][j-1]+h;
                a[i][j]=cost;
            }
//        System.out.println(a[n][m]);
        System.out.println(Math.round(a[n][m]));
    }
}
