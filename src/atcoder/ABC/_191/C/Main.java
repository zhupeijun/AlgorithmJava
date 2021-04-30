package atcoder.ABC._191.C;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int[][] DIR = { {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };

    private void solve() {
        int H = sc.nextInt();
        int W = sc.nextInt();

        char[][] g = sc.nextCharArray(H, W);

        int ans = 0;
        for (int i = 1; i < H; ++i) {
            boolean in = false;
            for (int j = 0; j < W; ++j) {

               if (g[i][j] != g[i-1][j]) {
                   if (!in) {
                       ++ans;
                   }
                   in = true;
               } else {
                   in = false;
               }
            }
        }

        for (int j = 1; j < W; ++j) {
            boolean in = false;
            for (int i = 0; i < H; ++i) {
                if (g[i][j] != g[i][j-1]) {
                    if (!in) {
                        ++ans;
                    }
                    in = true;
                } else {
                    in = false;
                }
            }
        }

        out.println(ans);
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
