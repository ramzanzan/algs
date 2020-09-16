package ramzanzan.problems.timus_0_99;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

public class timus1880 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 3;
        int[] p = new int[k];
        int[][] ns = new int[k][];
        for(int i=0;i<k;i++){
            int n=sc.nextInt();
            sc.nextLine();
            ns[i] = new int[n];
            for(int j=0;j<n;j++)
                ns[i][j]=sc.nextInt();
            sc.nextLine();
        }
        int res=0;
        try {
            int num=-1, tmp;
            while (true){
                for(int i=0;i<k;i++){
                    if(i==0){
                        num = ns[i][p[i]++];
                        continue;
                    }
                    while (ns[i][p[i]]<num) { p[i]++; }
                    if (ns[i][p[i]]>num) break;
                    p[i]++;
                    if(i==k-1) res++;
                }
            }
        }catch (IndexOutOfBoundsException e){}
        System.out.print(res);
    }

    class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
    }
}

//5
//13 20 22 43 146
//10
//1 2 3 13 22 43 146 200 201 202
//12
//1 2 3 4 13 43 67 89 146 150 151 500


//12
//1 2 3 4 13 43 67 89 146 150 151 500
//5
//13 20 22 43 146
//10
//1 2 3 13 22 43 146 200 201 202
