package ramzanzan.problems;

import java.util.Scanner;

public class timus1033 {

    static int[][] lb;
    static int wc;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        lb = new int[n][n];
        for(int i=0;i<n;i++){
            char[] chars = scanner.nextLine().toCharArray();
            for(int j=0;j<n;++j)
                lb[i][j]=chars[j]=='.' ? 0 : 8;
        }
        traverse(0, 0);
        if(lb[n-1][n-1]==0) traverse(n-1,n-1);
        System.out.println((wc-4)*9);
    }

    static void traverse(int i, int j){
        if(i<0 || i>=n || j<0 || j>=n  ) {
            wc++;
            return;
        }
        else if(lb[i][j]!=0){
            if(lb[i][j]==8) wc++;
            return;
        }
        switch (lb[i][j]){
            case 0: lb[i][j]++; traverse(i,j-1);
            case 1: lb[i][j]++; traverse(i-1,j);
            case 2: lb[i][j]++; traverse(i,j+1);
            case 3: lb[i][j]++; traverse(i+1,j);
        }
    }
}
