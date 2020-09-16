package ramzanzan.problems.timus_0_99;

import java.util.Scanner;

public class timus2199 {
    public static void main(String[] args) throws Exception {
        other();
        int b;
        int n = 0;
        while ( (b=System.in.read()) != '\n'){
            n = n*10 + (b-'0');
        }
        int res = n+2;
        for(int i=0;i<n;i++)
            while ( (b=System.in.read()) != '\n' && b!=-1){
                if (b=='+') {
                    res++;
                    System.in.read();
                    System.in.read();
                    System.in.read();
                }
            }
        System.out.println(res*100 + (res==13?100:0));
    }

    static void other(){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        sc.nextLine();
        int res = n+2;
        for(int i=0;i<n;i++)
            if(sc.nextLine().contains("+")) res++;
        System.out.println(res*100 + (res==13?100:0));
        System.exit(0);
    }
}
