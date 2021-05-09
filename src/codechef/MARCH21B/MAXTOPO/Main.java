package codechef.MARCH21B.MAXTOPO;

import java.io.*;
import java.util.*;

import library.algorithm.Mint;
import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;
    private static final Mint MT = new Mint();

    private int dfs(List<List<Integer>> g, int u, int fa, int N, List<int[]> list) {
        int cnt = 1;
        for (int v : g.get(u)) {
            if (v != fa) {
                cnt += dfs(g, v, u, N, list);
            }
        }

        if (fa != -1) {
            int pCnt = N - cnt;
            int diff = Math.abs(pCnt - cnt);
            list.add(new int[]{diff, pCnt, fa});
            list.add(new int[]{diff, cnt, u});
        }

        return cnt;
    }

    private int dfs2(List<List<Integer>> g, int u, int fa, int N, long[] ret) {
        int cnt = 1;
        for (int v : g.get(u)) {
            if (v != fa) {
                cnt += dfs2(g, v, u, N, ret);
            }
        }
        if (fa != -1) {
            ret[0] = MT.mul(ret[0], cnt);
        }
        return cnt;
    }

    private void solve() {
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<List<Integer>> g = cu.createGraph(N);

        for (int i = 1; i < N; ++i) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            g.get(u).add(v);
            g.get(v).add(u);
        }

        List<int[]> list = new ArrayList<>();
        dfs(g, 0, -1, N, list);

        list.sort((v1, v2) -> {
            if (v1[0] != v2[0]) return v1[0] - v2[0];
            if (v1[1] != v2[1]) return v2[1] - v1[1];
            return v2[2] - v1[2];
        });

        long t = 1;
        for (int i = 1; i < N; ++i) {
            t = MT.mul(t, i);
        }

        //list.forEach(x -> System.out.println(Arrays.toString(x)));
        if (K == 1) {
            long[] ans = new long[1]; ans[0] = 1;
            int root = list.get(0)[2];
            dfs2(g, root, -1, N, ans);
            out.println((root + 1) + " " + MT.div(t, ans[0]));
        } else {
            int root = list.get(0)[2];
            int i = 1;
            while (root == list.get(i)[2]) {
                ++i;
            }
            root = list.get(i)[2];
            long[] ans = new long[1]; ans[0] = 1;
            dfs2(g, root, -1, N, ans);
            out.println((root + 1) + " " + MT.div(t, ans[0]));
        }
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