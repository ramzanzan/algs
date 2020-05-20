package ramzanzan.problems;

import java.util.Scanner;

public class timus1146 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] rowSums = new int[n][n+1];
        for(int i=0;i<n;i++) {
            for (int j = 1; j <= n; j++)
                rowSums[i][j] = rowSums[i][j-1] + sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for(int colStart=1; colStart<=n; colStart++)
            for(int col=colStart; col<=n; col++){
                int sum=0;
                for(int row=0; row<n; row++){
                    sum += rowSums[row][col] - rowSums[row][colStart-1];
                    if(max<sum) max=sum;
                    if(sum<0) sum=0;
                }
            }

        System.out.println(max);

    }
}
//4
//        0 -2 -7 0
//        9 2 -6 2
//        -4 1 -4 1
//        -1 8 0 -2

//4
//        -20 -2 -1 9
//        9 2 -1 2
//        -4 1 100 1
//        -1 8 0 -10