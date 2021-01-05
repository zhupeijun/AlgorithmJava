package atcoder.ABC._160.F;

import java.io.*;
import java.util.*;

public class Main {
    private int N;
    private List<List<Integer>> g;
    private long[] value;
    private long[] cv;
    private int[] cnt;
    private long[] ans;


    private static final int MOD = 1000000007;

    private void init() {
        g = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            g.add(new ArrayList<>());
        }

        cv = new long[N + 1];
        cv[0] = 1;
        for (int i = 1; i <= N; i++) {
            cv[i] = i == 1 ? 1 : (cv[i - 1] * i) % MOD;
        }
    }

    private long pow(long a, int n) {
        long ret = 1;
        long base = a;
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

    private void dfs(int u, int fa) {
        int total = 0;
        long d = 1;
        value[u] = 1;
        for (int v : g.get(u)) {
            if (v != fa) {
                dfs(v, u);
                total += cnt[v];
                d = (d * cv[cnt[v]]) % MOD;
                value[u] = (value[u] * value[v]) % MOD;
            }
        }

        value[u] = (((value[u] * cv[total]) % MOD) * inv(d)) % MOD;
        cnt[u] = total + 1;
    }

    private void dfs2(int u, int fa, long fv) {
        long total = fv == -1 ? 1 : fv;
        long d = fv == -1 ? 1 : cv[N - cnt[u]];
        for (int v : g.get(u)) {
            if (v != fa) {
                total = (total * value[v]) % MOD;
                d = (d * cv[cnt[v]]) % MOD;
            }
        }

        ans[u] = (((total * cv[N - 1]) % MOD) * inv(d)) % MOD;

        for (int v : g.get(u)) {
            if (v != fa) {
                long t = (total * inv(value[v])) % MOD;
                long m = (d * inv(cv[cnt[v]])) % MOD;
                t = (t * inv(m)) % MOD;
                t = (t * cv[N - cnt[v] - 1]) % MOD;
                dfs2(v, u, t);
            }
        }
    }

    private void solve() {
        N = sc.nextInt();
        init();
        for (int i = 1; i < N; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            g.get(u).add(v);
            g.get(v).add(u);
        }

        value = new long[N];
        ans = new long[N];
        cnt = new int[N];

        dfs(0, -1);
        dfs2(0, -1, -1);

        for (long v : ans) {
            out.println(v);
        }
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
