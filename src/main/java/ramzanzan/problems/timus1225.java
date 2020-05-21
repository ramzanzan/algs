package ramzanzan.problems;

import java.util.Scanner;

public class timus1225 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        if(n<3) {
            System.out.println(2);
            return;
        }
        int bmax = (n-1)/2;
        long sum = 1;
        long spaces = n%2==1 ? bmax : bmax+1;
        long freeSpaces = n%2==1 ? 0 : 1;
        long part = n%2==1 ? 1 : bmax+1;
        sum+=part;
        for(int blues=bmax-1; blues>0; blues--) {
            spaces++;
            freeSpaces+=2;
            part = part*spaces*(blues+1)/(freeSpaces*(freeSpaces-1));
            sum += part;
        }
        System.out.println(sum*2);
    }
}
