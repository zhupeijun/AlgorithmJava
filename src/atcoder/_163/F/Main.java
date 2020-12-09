package atcoder._163.F;

import java.io.*;
import java.util.*;

public class Main {
    private int[] c;
    private List<List<Integer>> g;

    private long[] cnt;
    private long[] ans;

    private int dfs(int u, int fa) {
        cnt[c[fa]] = 0;
        int total = 1;
        long before = cnt[c[u]];
        for(int v : g.get(u)) {
            if (v != fa) {
                total += dfs(v, u);
            }
        }

        if (c[u] != c[fa]) {
            long r = total - cnt[c[fa]];
            ans[c[fa]] += r * (r + 1) / 2;
        }
        cnt[c[u]] += total - (cnt[c[u]] - before);
        return total;
    }

    private void solve() {
        int n = sc.nextInt();
        c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt() - 1;
        }

        g = new ArrayList<>();
        add(g, n);

        for (int i = 1; i < n; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            g.get(u).add(v);
            g.get(v).add(u);
        }

        cnt = new long[n];
        ans = new long[n];

        int total = 1;
        for (int v : g.get(0)) {
            total += dfs(v, 0);
        }

        for (int k = 0; k < n; k++) {
            if (k != c[0]) {
                long r = total - cnt[k];
                ans[k] += r * (r + 1) / 2;
            }
        }



        long all = (long) n * (n + 1) / 2;

        for (long v : ans) {
            out.println(all - v);
        }
    }

    private void add(List<List<Integer>> a, int n) {
        for (int i = 0; i < n; i++) {
            a.add(new ArrayList<>());
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
