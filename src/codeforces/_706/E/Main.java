package codeforces._706.E;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private void print(char[][] s) {
        for (char[] r : s) {
            out.println(String.valueOf(r));
        }
    }

    private void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] a = sc.nextCharArray(n, m);

        if (n == 1) {
            for (int j = 0; j < m; ++j) a[0][j] = 'X';
            print(a);
            return;
        } else if (m == 1) {
            for (int i = 0; i < n; ++i) a[i][0] = 'X';
            print(a);
            return;
        }

        int start = 0;
        if (n % 3 == 0) {
            start = 1;
        }

        for (int i = start; i < n; i += 3) {
            for (int j = 0; j < m; ++j) {
                a[i][j] = 'X';
            }
        }

        for (int i = start + 1; i + 1 < n; i += 3) {
            int vj = -1;
            for (int j = 0; j < m; ++j) {
                if (a[i][j] == 'X') {
                    vj = j;
                    break;
                }
            }

            if (vj != -1) {
                a[i + 1][vj] = 'X';
                continue;
            }

            vj = -1;
            for (int j = 0; j < m; ++j) {
                if (a[i+1][j] == 'X') {
                    vj = j;
                    break;
                }
            }



            if (vj != -1) {
                a[i][vj] = 'X';
                continue;
            }

            a[i][0] = 'X';
            a[i+1][0] = 'X';
        }

        print(a);
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