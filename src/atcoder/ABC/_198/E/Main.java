package atcoder.ABC._198.E;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private int N;
    private int[] c;
    private List<List<Integer>> g;
    private List<Integer> ans;

    private void dfs(int u, int fa, Map<Integer, Integer> s) {
        s.put(c[u], s.getOrDefault(c[u], 0) + 1);
        if (s.get(c[u]) == 1) ans.add(u + 1);
        for (int v : g.get(u)) {
            if (v != fa) {
                dfs(v, u, s);
            }
        }
        s.put(c[u], s.get(c[u])-1);
    }

    private void solve() {

        N = sc.nextInt();
        c = sc.nextIntArray(N);
        g = cu.createGraph(N);
        for (int i = 1; i < N; ++i) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;

            g.get(u).add(v);
            g.get(v).add(u);
        }

        ans = new ArrayList<>();
        dfs(0, -1, new HashMap<>());
        Collections.sort(ans);
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