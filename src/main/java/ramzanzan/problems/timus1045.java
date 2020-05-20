package ramzanzan.problems;

import java.util.Arrays;
import java.util.Scanner;

public class timus1045 {

    static String loseMsg = "First player loses";
    static String winMsg = "First player wins flying to airport ";

    static int[][] adjacent = new int[1001][21];  //adj[x][0] is length
    static boolean[] visited = new boolean[1001];
    static int n;
    static int s;
    static int winAirportIndex =1;

    static boolean spec_dfs(boolean player, int node){
        boolean winner;
        visited[node]=true;
        for(; winAirportIndex <=adjacent[node][0]; winAirportIndex++){
            int next = adjacent[node][winAirportIndex];
            if(visited[next]) continue;
            winner = dfs(!player, next);
            if(winner==player) {
                return winner;
            }
        }
        return !player;
    }

    static boolean dfs(boolean player, int node){
        boolean winner;
        visited[node]=true;
        for(int i=1; i<=adjacent[node][0]; i++){
            int next = adjacent[node][i];
            if(visited[next]) continue;
            if(dfs(!player, next)==player) {
                visited[node]=false;
                return player;
            }
        }
        visited[node]=false;
        return !player;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextShort();
        s = scanner.nextShort();
        if(n==1 || n==0){ System.out.println(loseMsg); return; }
        for(int i=0;i<n-1;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(a==b) continue;
            adjacent[a][++adjacent[a][0]]=b;
            adjacent[b][++adjacent[b][0]]=a;
        }
        Arrays.sort(adjacent[s],1,adjacent[s][0]+1);
        if(spec_dfs(true,s))
            System.out.println(winMsg+adjacent[s][winAirportIndex]);
        else
            System.out.println(loseMsg);
    }
}
//7 3
//3 1
//3 2
//1 7
//1 4
//4 2
//5 4
//6 5
//
//8 3
//3 1
//3 2
//2 8
//1 7
//1 4
//4 2
//5 4
//6 5