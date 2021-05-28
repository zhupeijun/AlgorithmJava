package atcoder.ABC._201;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private int get(char c) {
        return c == '+' ? 1 : -1;
    }

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] c = sc.nextCharArray(N, M);
        int[][] a = new int[N][M];

        for (int i = N-1; i >= 0; --i) {
            for (int j = M-1; j >= 0; --j) {
                if (i == N-1 && j == M-1) {
                    continue;
                } else if (i == N-1) {
                    a[i][j] = a[i][j+1];
                    int v = get(c[i][j+1]);
                    if ((i+j) % 2 == 0) {
                        a[i][j] += v;
                    } else {
                        a[i][j] -= v;
                    }
                } else if (j == M-1) {
                    a[i][j] = a[i+1][j];
                    int v = get(c[i+1][j]);
                    if ((i+j) % 2 == 0) {
                        a[i][j] += v;
                    } else {
                        a[i][j] -= v;
                    }
                } else {
                    if ((i+j) % 2 == 0) {
                        int vr = a[i][j+1] + get(c[i][j+1]);
                        int vd = a[i+1][j] + get(c[i+1][j]);
                        a[i][j] = Math.max(vr, vd);
                    } else {
                        int vr = a[i][j+1] - get(c[i][j+1]);
                        int vd = a[i+1][j] - get(c[i+1][j]);
                        a[i][j] = Math.min(vr, vd);
                    }
                }
            }
        }

        if (a[0][0] > 0) {
            out.println("Takahashi");
        } else if (a[0][0] < 0) {
            out.println("Aoki");
        } else {
            out.println("Draw");
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
