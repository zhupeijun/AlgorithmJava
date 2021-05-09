package kickstart._2021.RoundA.D;

import java.io.*;
import java.util.*;

import library.algorithm.UnionSet;
import library.basic.*;

public class Solution {
    private static final boolean N_CASE = true;

    private static class Edge implements Comparable<Edge> {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return o.w - w;
        }
    }

    private void solve() {
        int N = sc.nextInt();
        int[][] A = sc.nextIntArray(N, N);
        int[][] B = sc.nextIntArray(N, N);
        int[] R = sc.nextIntArray(N);
        int[] C = sc.nextIntArray(N);

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == -1) {
                    edges.add(new Edge(i, j + N, B[i][j]));
                }
            }
        }

        Collections.sort(edges);

        UnionSet us = new UnionSet(N+N);
        int ans = 0;
        for (Edge e : edges) {
            if (us.find(e.u) == us.find(e.v)) {
                ans += e.w;
                continue;
            }

            us.union(e.u, e.v);
        }
        out.println(ans);
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            out.print(String.format("Case #%d: ", t + 1));
            solve();
        }
    }

    private static MyWriter out;
    private static MyScanner sc;
    private static CommonUtils cu;

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Solution().run();
        out.close();
    }
}