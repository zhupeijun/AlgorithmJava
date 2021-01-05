package atcoder.ABC._163.D;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final long MOD = 1000000007;

    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        long start = 0;
        long end = 0;
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            start = (start + i) % MOD;
            end = (end + n - i) % MOD;
            if (i >= k - 1) {
                ans = (ans + end - start + 1 + MOD) % MOD;
            }
        }

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
