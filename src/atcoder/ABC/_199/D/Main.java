package atcoder.ABC._199.D;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private List<List<Integer>> g;
    private int N;
    private int M;
    private long w;

    private void dfs1(int u, int fu, List<Integer> a, boolean[] vis, int[] fa) {
        if (vis[u]) return;
        vis[u] = true;
        fa[u] = fu;
        a.add(u);
        for (int v : g.get(u)) {
            dfs1(v, u, a, vis, fa);
        }
    }

    private void dfs2(List<Integer> a, int k, int[] c, int[] fa) {
        if (k == a.size()) { 
            ++w; 
            return; 
        }

        int u = a.get(k);
        for (int i = 0; i < 3; ++i) {
            if (c[fa[u]] != i) {
                boolean ok = true;
                for (int v : g.get(u)) {
                    if (c[v] == i) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    c[u] = i;
                    dfs2(a, k+1, c, fa);
                    c[u] = -1;
                }
            }
        }
    }

    private void solve() {
        N = sc.nextInt();
        M = sc.nextInt();

        g = cu.createGraph(N);

        for (int i = 0; i < M; ++i) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            g.get(u).add(v);
            g.get(v).add(u);
        }

        long ans = 1;
        boolean[] vis = new boolean[N];
        int[] c = new int[N]; Arrays.fill(c, -1);
        int[] fa = new int[N]; Arrays.fill(fa, -1);
        for (int i = 0; i < N; ++i) {
            if (vis[i]) continue;
            List<Integer> a = new ArrayList<>();
            dfs1(i, -1, a, vis, fa);

            w = 0;
            for (int k = 0; k < 3; ++k) {
                c[i] = k;
                dfs2(a, 1, c, fa);
            }
            ans = ans * w;
        }
        out.println(ans);
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            solve();
        }
    }

    private static MyWriter out;
    private static MyScanner sc;
    private static CommonUtils cu;

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        cu = new CommonUtils();
        new Main().run();
        out.close();
    }
}
