package codechef.MARCH21B.CONSADD;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private void solve() {
        int R = sc.nextInt();
        int C = sc.nextInt();
        int X = sc.nextInt();

        int[][] g = new int[X][X];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                g[i%X][j%X] += sc.nextInt();
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                g[i%X][j%X] -= sc.nextInt();
            }
        }

        for (int j = 0; j < X; j++) {
            for (int i = X-1; i >= 0; i--) {
                g[i][j] -= g[0][j];
            }
        }

        boolean good = true;
        for (int i = 0; i < X; i++) {
            for (int j = 1; j < X; j++) {
                if (g[i][j] != g[i][j-1]) {
                    good = false; break;
                }
            }
            if (!good) break;
        }

        out.println(good ? "Yes" : "No");
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