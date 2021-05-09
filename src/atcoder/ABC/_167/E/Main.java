package atcoder.ABC._167.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 998244353;

    private long[] nu;
    private long[] de;

    private long pow(long a, long n) {
        long ret = 1, base = a;
        while (n > 0) {
            if ((n & 1) > 0) {
                ret = (ret * base) % MOD;
            }
            base = (base * base) % MOD;
            n >>= 1;
        }
        return ret;
    }

    private long inv(long a) {
        return pow(a, MOD - 2);
    }

    private long c(int n, int m) {
        if (m == 0 || n == m) {
            return 1;
        }
        return (nu[m] * inv(de[m])) % MOD;
    }

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        nu = new long[N];
        de = new long[N];
        nu[0] = de[0] = 1;
        for (int i = 1; i < N; i++) {
            nu[i] = ((N - i) * nu[i - 1]) % MOD;
            de[i] = (i * de[i - 1]) % MOD;
        }

        long ans = 0;
        for (int i = 0; i <= K; i++) {
            long t = c(N - 1, N - 1 - i);
            t = t * pow(M - 1, N - 1 - i) % MOD;
            t = t * M % MOD;
            ans = (ans + t) % MOD;
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
