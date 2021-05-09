package atcoder.ARC._116.A;

import java.io.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private void solve() {
        long N = sc.nextLong();
        if (N == 1) {
            out.println("Odd");
            return;
        }

        N -= 2;
        N %= 4;
        if (N == 0) out.println("Same");
        else if (N == 1 || N == 3)out.println("Odd");
        else out.println("Even");
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