package atcoder.ARC._115.A;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();

        int odd = 0, even = 0;
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    ++cnt;
                }
            }
            if (cnt % 2 == 0) {
                ++even;
            } else {
                ++odd;
            }
        }
        out.println((long)even * odd);
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