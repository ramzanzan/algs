package ramzanzan.problems;

import java.util.*;

public class timus1126 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> insteadOfHeap = new TreeMap<>();
        int M = sc.nextInt();
        Queue<Integer> range = new ArrayDeque<>(M);
        int lastIdx = 0;
        int v;
        for(int i = 0; i<M; i++) {
            v = sc.nextInt();
            range.add(v);
            insteadOfHeap.put(v,i);
        }
        System.out.println(insteadOfHeap.lastKey());
        v=sc.nextInt();
        while (v!=-1){
            insteadOfHeap.remove(range.poll(),lastIdx);
            range.add(v);
            insteadOfHeap.put(v, lastIdx + M );
            lastIdx++;
            System.out.println(insteadOfHeap.lastKey());
            v=sc.nextInt();
        }
    }
}
