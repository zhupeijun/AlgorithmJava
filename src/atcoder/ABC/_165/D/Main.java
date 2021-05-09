package atcoder.ABC._165.D;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        long A = sc.nextLong();
        long B = sc.nextLong();
        long N = sc.nextLong();

        if (N > B - 1) {
            N = B - 1;
        }

        long ans = (long)Math.floor(1.0 * A * N / B) - (long)Math.floor(1.0 * N / B) * A;
        out.println(ans);
    }

    private static PrintWriter out;
    private static MyScanner sc;

    private static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        private MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().solve();
        out.close();
    }
}
