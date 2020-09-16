package ramzanzan.problems.timus_0_99;


public class timus1197 {
    public static void main(String[] args) throws Exception {
        int[][] leftBottom = {{2,3,4,4},{3,4,6,6},{4,6,8,8},{4,6,8,8}};
        int n = System.in.read()-'0';
        int secondByte = System.in.read();
        if (secondByte!='\n') {
            n=n*10+(secondByte-'0');
            System.in.read();
        }
        for(int i=0;i<n;i++){
            int x = System.in.read()-'a';
            if(x>=4) x=7-x;
            int y = System.in.read()-'1';
            if(y>=4) y=7-y;
            System.out.println(leftBottom[y][x]);
            System.in.read();
        }
    }
}
