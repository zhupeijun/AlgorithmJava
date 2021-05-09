package codeforces._703.C;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private int query(int l, int r) {
        out.println(String.format("? %d %d", l, r));
        out.flush();

        return sc.nextInt();
    }

    private void answer(int value) {
        out.println(String.format("! %d", value));
        out.flush();
    }

    private void solve() {
        int n = sc.nextInt();
        int secIdx = query(1, n);
        int l, r;
        if (secIdx != n && query(secIdx, n) == secIdx) {
            l = secIdx + 1; r = n;
            if (l == r) { answer(l); return; }

            while (l + 1 < r) {
                int mid = (l + r) / 2;
                if (query(secIdx, mid) == secIdx) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            if (l == r) { answer(l); return; }
            answer(query(l, r) == l ? r : l);
        } else {
            l = 1; r = secIdx - 1;
            if (l == r) { answer(l); return; }

            while (l + 1 < r) {
                int mid = (l + r) / 2;
                if (query(mid, secIdx) == secIdx) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }

            if (l == r) { answer(l); return; }
            answer(query(l, r) == l ? r : l);
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