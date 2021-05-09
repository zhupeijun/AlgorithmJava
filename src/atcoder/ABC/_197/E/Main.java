package atcoder.ABC._197.E;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        List<List<Integer>> g = cu.createGraph(N+2);
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int c = sc.nextInt();

            g.get(c).add(x);
        }
        g.get(N+1).add(0);

        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i < g.size(); ++i) {
            List<Integer> list = g.get(i);
            if (list.size() == 0) continue;
            Collections.sort(list);
            a.add(list);
        }

        int m = a.size();
        long[][] dp = new long[m][2];
        for (int i = 0; i < m; ++i) Arrays.fill(dp[i], 1_000_000_000_000_000_00L);

        long l0 = a.get(0).get(0);
        long r0 = a.get(0).get(a.get(0).size()-1);
        dp[0][0] = Math.abs(r0) + r0 - l0;
        dp[0][1] = Math.abs(l0) + r0 - l0;
        for (int i = 0; i < m-1; ++i) {
            List<Integer> cur = a.get(i);
            List<Integer> nxt = a.get(i+1);

            long cl = cur.get(0);
            long cr = cur.get(cur.size() - 1);
            long nl = nxt.get(0);
            long nr = nxt.get(nxt.size() - 1);

            dp[i+1][0] = Math.min(dp[i+1][0], dp[i][0] + Math.abs(nr-cl) + Math.abs(nr-nl));
            dp[i+1][0] = Math.min(dp[i+1][0], dp[i][1] + Math.abs(nr-cr) + Math.abs(nr-nl));
            dp[i+1][1] = Math.min(dp[i+1][1], dp[i][0] + Math.abs(nl-cl) + Math.abs(nr-nl));
            dp[i+1][1] = Math.min(dp[i+1][1], dp[i][1] + Math.abs(nl-cr) + Math.abs(nr-nl));
        }
        out.println(Math.min(dp[m - 1][0], dp[m - 1][1]));
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