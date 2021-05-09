package uva._11520;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private void solve() {
        int n = sc.nextInt();
        char[][] a = sc.nextCharArray(n, n);
        int[][] d = {{-1,0}, {1, 0}, {0, 1}, {0,-1}};
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (a[i][j] != '.') continue;

                Set<Character> s = new HashSet<>();
                for (int k = 0; k < 4; ++k) {
                    int ni = d[k][0] + i;
                    int nj = d[k][1] + j;
                    if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                        if (a[ni][nj] != '.') s.add(a[ni][nj]);
                    }
                }

                for (char ci = 0; ci < 26; ++ci) {
                    char c = (char)('A' + ci);
                    if (!s.contains(c)) {
                        a[i][j] = c;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            out.println(String.valueOf(a[i]));
        }
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            out.println(String.format("Case %d:", t + 1));
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