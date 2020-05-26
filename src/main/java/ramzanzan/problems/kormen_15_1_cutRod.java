package ramzanzan.problems;

import ramzanzan.util.NumPair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class kormen_15_1_cutRod {

    static final Map<Integer,Integer> PRICES = new HashMap<>();
    static {
        PRICES.put(1,1);
        PRICES.put(2,5);
        PRICES.put(3,8);
        PRICES.put(4,9);
        PRICES.put(5,10);
        PRICES.put(6,17);
        PRICES.put(7,17);
        PRICES.put(8,20);
        PRICES.put(9,24);
        PRICES.put(10,30);
    }

    Map<Integer,Integer> prices;
    int rodLen;

    public kormen_15_1_cutRod(Map<Integer,Integer> prices, int rodLen){
        this.prices = prices;
        this.rodLen=rodLen;
    }

    public kormen_15_1_cutRod(int rodLen){
        this.prices=PRICES;
        this.rodLen=rodLen;
    }

    Map<NumPair<Integer,Integer>,Integer> Solutions = new HashMap<>();

    int DownwardWithMemo1(int n){
        if(n==0) return 0;
        int m = Integer.MIN_VALUE;
        int end = n==1 ? 0 : n/2+n%2;
        for(int i=0;i<=end;++i){
            NumPair<Integer,Integer> np = new NumPair<>(n-i,i);
            if(!Solutions.containsKey(np))
                Solutions.put(np,prices.get(n-i)+ DownwardWithMemo1(i));
            m=Math.max(m,Solutions.get(np));
        }
        return m;
    }

    public int DownwardWithMemo1(){
        Solutions.clear();
        return DownwardWithMemo1(rodLen);
    }

    int DownwardWithMemo2(int[] res,int n){
        if(res[n]>=0) return res[n];
        int q = -1;
        for(int i=1;i<=n;++i)
            q=Math.max(q,prices.get(i)+DownwardWithMemo2(res,n-i));
        res[n]=q;
        return q;
    }

    public int DownwardWithMemo2(){
        int[] res = new int[rodLen+1];
        Arrays.fill(res,-1);
        res[0]=0;
        return DownwardWithMemo2(res,rodLen);
    }

    public int BottomUpWithMemo(){
        int[] res = new int[rodLen+1];
        Arrays.fill(res,-1);
        res[0]=0;
        int q = -1;
        for(int i=1;i<=rodLen;++i){
            q=res[i];
            for(int j=1;j<=i;++j)
                q=Math.max(q,prices.get(j)+res[i-j]);
            res[i]=q;
        }
        return q;
    }
}
