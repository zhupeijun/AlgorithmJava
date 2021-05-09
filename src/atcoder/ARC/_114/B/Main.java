package atcoder.ARC._114.B;

import java.io.*;
import java.util.*;

import library.algorithm.Mint;
import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final Mint MT = new Mint(998244353);

    private void dfs(List<List<Integer>> g, boolean[] vis, int u) {
        vis[u] = true;
        for (int v : g.get(u)) {
            if (!vis[v]) {
                dfs(g, vis, v);
            }
        }
    }

    private void solve() {

        int N = sc.nextInt();
        int[] f = new int[N];
        for (int i = 0; i < N; i++) {
            f[i] = sc.nextInt() - 1;
        }

        List<List<Integer>> g = cu.createGraph(N);

        int cnt = 0;
        int[] d = new int[N];
        for (int i = 0; i < N; i++) {
            if (f[i] != i) {
                g.get(i).add(f[i]);
                ++d[f[i]];
            } else {
                ++cnt;
            }
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (d[i] == 0) {
                q.add(i);
            }
        }

        boolean[] vis = new boolean[N];
        while (!q.isEmpty()) {
            int u = q.poll();
            vis[u] = true;
            for (int v : g.get(u)) {
                --d[v];
                if (d[v] == 0) {
                    q.add(v);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                dfs(g, vis, i);
                ++cnt;
            }
        }

        long ans = MT.pow(2, cnt);
        ans = MT.sub(ans, 1);
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