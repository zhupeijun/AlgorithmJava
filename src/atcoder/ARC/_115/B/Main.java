package atcoder.ARC._115.B;

import java.io.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int[][] a = sc.nextIntArray(N, N);
        int[] B = new int[N];
        for (int j = 0; j < N; ++j) {
            B[j] = Integer.MAX_VALUE;
            for (int i = 0; i < N; ++i) {
                B[j] = Math.min(B[j], a[i][j]);
            }
        }

        int[] A = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = a[i][0] - B[0];
        }

        for (int j = 1; j < N; ++j) {
            for (int i = 0; i < N; ++i) {
                int t = a[i][j] - B[j];
                if (t != A[i]) {
                    out.println("No");
                    return;
                }
            }
        }

        out.println("Yes");
        out.printArray(A);
        out.printArray(B);
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
        new Main().run();
        out.close();
    }
}