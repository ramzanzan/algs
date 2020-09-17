package ramzanzan.problems.timus_100_500;

import java.util.*;

import static java.lang.Integer.parseInt;

public class t1072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer>[] adjs = new Set[n+1];
        for(int i=1;i<=n;i++) adjs[i]=new HashSet<>();
        Map<Integer,List<Integer>> nets = new HashMap<>();
        for(int i=1;i<=n;i++){
            int k = sc.nextInt();
            sc.nextLine();
            for(int j=0;j<k;j++) {
                String[] line = sc.nextLine().split("[. ]");
                int ip =    ((parseInt(line[0])<<24) |(parseInt(line[1])<<16) |(parseInt(line[2])<<8) | parseInt(line[3]));
                int mask =  ((parseInt(line[4])<<24) |(parseInt(line[5])<<16) |(parseInt(line[6])<<8) | parseInt(line[7]));
                int net = ip & mask;
                List<Integer> nbrs = nets.getOrDefault(net, new LinkedList<>());
                for(Integer nb : nbrs){
                    adjs[nb].add(i);
                    adjs[i].add(nb);
                }
                nbrs.add(i);
                if(!nets.containsKey(net)) nets.put(net,nbrs);
            }
        }
        int from = sc.nextInt(), to = sc.nextInt();
        LinkedList<String> route = new LinkedList<>();
        boolean r = bfs(route,from,to,new boolean[n+1],adjs);
        if(!r) System.out.println("No");
        else{
           System.out.println("Yes");
           System.out.print(String.join(" ",route)+" "+to);
        }

    }

    static boolean bfs(Deque<String> route, int from, int to, boolean[] visited, Set<Integer>[] adjs){
        if (visited[from]) return false;
        visited[from]=true;
        if(adjs[from].contains(to)){
            route.push(String.valueOf(from));
            return true;
        }
        for(int nb : adjs[from]){
            boolean b = bfs(route, nb, to, visited, adjs);
            if(b){
                route.push(String.valueOf(from));
                return true;
            }
        }
        return false;
    }

    //todo rewrite with bfs over networks
}
