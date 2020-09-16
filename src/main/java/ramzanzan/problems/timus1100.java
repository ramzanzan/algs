package ramzanzan.problems;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class timus1000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] countOfTeamsThatSolvedSuchNumberOfProblems = new int[101];
        List<Integer>[] solvedProblems_X_teamsNo = new List[101];
        for(int i=0;i<N;i++){
            int t = sc.nextInt();
            int m = sc.nextInt();
            if(countOfTeamsThatSolvedSuchNumberOfProblems[m]++==0)
                solvedProblems_X_teamsNo[m]=new LinkedList<Integer>();
            solvedProblems_X_teamsNo[m].add(t);
        }
        for(int i=100;i>=0;i--)
            for(int j=0; j<countOfTeamsThatSolvedSuchNumberOfProblems[i];j++)
                System.out.println(solvedProblems_X_teamsNo[i].get(j)+" "+i);
    }
}

//todo - TLE: fast reading/scaning