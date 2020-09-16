package ramzanzan.problems.timus_0_99;

import java.util.*;


public class timus1001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Double> results = new LinkedList<>();
        try {
            while (true)
                results.push(Math.sqrt(sc.nextLong()));
        }catch (NoSuchElementException e){

        }
        try {
            while (true)
                System.out.printf("%.4f\n",results.pop());
        }catch (Exception e){

        }
    }
}
