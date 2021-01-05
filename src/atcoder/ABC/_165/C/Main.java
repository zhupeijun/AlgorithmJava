package atcoder.ABC._165.C;

import java.io.*;
import java.util.*;

public class Main {
    private long max;
    private int[][] qs;
    private int N;
    private int M;
    private int Q;

    private long getScore(int[] A) {
        long score = 0;
        for (int[] q : qs) {
            if (A[q[1] - 1] - A[q[0] - 1] == q[2]) {
                score += q[3];
            }
        }
        return score;
    }

    private void dfs(int i, int k, int[] A) {
        A[i] = k;
        if (i == N - 1) {
            max = Math.max(max, getScore(A));
            return;
        }

        for (int t = k; t <= M; ++t) {
            dfs(i + 1, t, A);
        }
    }

    private void solve() {
        N = sc.nextInt();
        M = sc.nextInt();
        Q = sc.nextInt();

        qs = new int[Q][4];
        for (int i = 0; i < Q; i++) {
            for (int j = 0; j < 4; j++) {
                qs[i][j] = sc.nextInt();
            }
        }

        int[] A = new int[N];
        for (int i = 1; i <= M; ++i) {
            dfs(0, i, A);
        }
        out.println(max);
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
