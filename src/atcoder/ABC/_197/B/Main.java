package atcoder.ABC._197.B;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt() - 1;
        int Y = sc.nextInt() - 1;

        char[][] s = sc.nextCharArray(N, M);
        int cnt = 1;
        for (int i = X+1; i < N; ++i) {
            if (s[i][Y] == '.') ++cnt;
            else break;
        }

        for (int i = X-1; i >= 0; --i) {
            if (s[i][Y] == '.') ++cnt;
            else break;
        }

        for (int j = Y+1; j < M; ++j) {
            if (s[X][j] == '.') ++cnt;
            else break;
        }

        for (int j = Y-1; j >= 0; --j) {
            if (s[X][j] == '.') ++cnt;
            else break;
        }

        out.println(cnt);
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