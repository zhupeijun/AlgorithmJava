package atcoder.ABC._194.A;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int A = sc.nextInt();
        int B = sc.nextInt();

        int MS = A + B;
        if (MS >= 15 && B >= 8) {
            out.println(1);
        } else if (MS >= 10 && B >= 3) {
            out.println(2);

        } else if (MS >= 3) {
            out.println(3);
        } else {
            out.println(4);
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