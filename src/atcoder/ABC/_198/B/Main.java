package atcoder.ABC._198.B;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int k = sc.nextInt();
        if (k == 0) {
            out.println("Yes");
            return;
        }

        while (k % 10 == 0) k/=10;

        String s = String.valueOf(k);
        int l = 0, r = s.length()-1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            ++l; --r;
        }

        if (l < r) {
            out.println("No");
        } else {
            out.println("Yes");
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