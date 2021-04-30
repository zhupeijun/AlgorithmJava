package atcoder.ABC._190.E;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<List<Integer>> g = cu.createGraph(N + 1);
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.get(u).add(v);
            g.get(v).add(u);
        }

        int K = sc.nextInt();
        int[] C = sc.nextIntArray(K);
        Map<Integer, Integer> id = new HashMap<>();
        for (int i = 0; i < K; ++i) {
            id.put(C[i], i);
        }

        int[][] dist = new int[K][K];
        cu.fill(dist, -1);

        for (int st : C) {
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[] { st, 0});
            boolean[] vis = new boolean[N+1];
            vis[st] = true;
            while (!q.isEmpty()) {
                int[] t = q.poll();
                int u = t[0];
                int d = t[1];

                if (id.containsKey(u)) {
                    dist[id.get(st)][id.get(u)] = d;
                    dist[id.get(u)][id.get(st)] = d;
                }
                for (int v : g.get(u)) {
                    if (!vis[v]) {
                        q.add(new int[] {v, d+1 });
                        vis[v] = true;
                    }
                }
            }
        }

        for (int i = 0; i < K; ++i) {
            for (int j = 0; j < K; ++j) {
                if (dist[i][j] == -1) {
                    out.println(-1);
                    return;
                }
            }
        }

        int maskMax = 1 << K;
        final int MAX = 1000000;
        int[][] dp = new int[maskMax][K];
        cu.fill(dp, MAX);
        for (int i = 0; i < K; ++i) {
            dp[1 << i][i] = 0;
        }

        for (int mask = 0; mask < maskMax; ++mask) {
            for (int last = 0; last < K; ++last) {
                if (dp[mask][last] == MAX) continue;
                for (int next = 0; next < K; ++next) {
                    int nextBit = 1 << next;
                    if ((nextBit & mask) > 0) continue;
                    int nextMask = mask | nextBit;
                    dp[nextMask][next] = Math.min(dp[nextMask][next], dp[mask][last] + dist[last][next]);
                }
            }
        }

        out.println(Arrays.stream(dp[maskMax - 1]).min().orElse(-2) + 1);
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
