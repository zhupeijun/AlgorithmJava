package codeforces._706.B;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> a = sc.nextList(n);
        Collections.sort(a);

        if (k == 0) {
            out.println(n);
            return;
        }

        int mex = 0;
        for (int v : a) {
            if (v == mex) ++mex;
            else break;
        }

        int max = -1;
        for (int v : a) {
            max = Math.max(v, max);
        }

        if (mex > max) {
            out.println(n + k);
        } else {
            int half = (mex + max + 1) / 2;
            boolean exist = false;
            for (int v : a) {
                if (v == half) { exist = true; break; }
            }

            if (exist) {
                out.println(n);
            } else {
                out.println(n + 1);
            }
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
        new Main().run();
        out.close();
    }
}