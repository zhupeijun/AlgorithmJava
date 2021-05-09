package atcoder.ABC.jsc2021;

import java.io.*;
import java.util.*;

import library.basic.*;
import library.algorithm.Mint;

public class Main {
    private static final boolean N_CASE = false;
    private static Mint Mt = new Mint();

    private void solve() {
        int N = sc.nextInt();
        int P = sc.nextInt();
        long ans = Mt.mul(Mt.pow(P-2, N-1), P-1);
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
