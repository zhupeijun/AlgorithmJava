package atcoder._162.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 1000000007;

    private long pow(long a, int n) {
        long ret = 1;
        long base = a;
        while (n > 0) {
            if ((n & 1) > 0) {
                ret = (ret * base) % MOD;
            }
            n >>= 1;
            base = (base * base) % MOD;
        }
        return ret;
    }

    private void solve() {
        int N = sc.nextInt();
        int K = sc.nextInt();

        long ans = 0;
        long cnt = 0;
        long[] fn = new long[K + 1];
        for (int i = K; i > 1; --i) {
            long v = K / i;
            v = (pow(v, N) - fn[i] + MOD) % MOD;
            int j = 2;
            while ((long)j * j <= i) {
                if (i % j == 0) {
                    fn[j] = (fn[j] + v) % MOD;
                    int k = i / j;
                    if (k != j && k != i) {
                        fn[k] = (fn[k] + v) % MOD;
                    }
                }
                ++j;
            }
            cnt = (cnt + v) % MOD;
            ans = (ans + (v * i)) % MOD;
        }
        ans = (ans + (pow(K, N) - cnt + MOD) % MOD) % MOD;
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
