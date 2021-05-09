package atcoder.ABC._199.F;

import java.io.*;
import java.util.*;

import library.basic.*;
import library.algorithm.Mint;
import library.algorithm.Matrix;

public class Main {
    private static final boolean N_CASE = false;
    private static final Mint Mt = new Mint();
    private static final Matrix Mtx = new Matrix(Mt);

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        long[] A = sc.nextLongArray(N);

        List<List<Integer>> g = cu.createGraph(N);
        for (int i = 0; i < M; ++i) {
            int X = sc.nextInt()-1;
            int Y = sc.nextInt()-1;

            g.get(X).add(Y);
            g.get(Y).add(X);
        }

        long[][] mat = new long[N][N];
        for (int u = 0; u < N; ++u) {
            int sz = g.get(u).size();
            mat[u][u] = Mt.div(2*M-sz, 2*M);

            for (int v : g.get(u)) {
                mat[u][v] = Mt.div(1, 2*M);
            }
        }

        A = Mtx.mul(A, Mtx.pow(mat, K));

        out.println(A);
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
