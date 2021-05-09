package atcoder.ABC._167.C;

import java.io.*;
import java.util.*;

public class Main {

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();

        int[][] A = new int[N][M];
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = sc.nextInt();
            for (int j = 0; j < M; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        int min = Integer.MAX_VALUE;
        int bitMax = 1 << N;
        for (int mask = 0; mask < bitMax; ++mask) {
            int[] l = new int[M];
            int c = 0;
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) == 0) {
                    continue;
                }

                c += C[i];
                for (int j = 0; j < M; j++) {
                    l[j] += A[i][j];
                }
            }

            boolean ok = true;
            for (int j = 0; j < M; j++) {
                if (l[j] < X) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                min = Math.min(c, min);
            }
        }

        if (min == Integer.MAX_VALUE) {
            out.println(-1);
        } else {
            out.println(min);
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
