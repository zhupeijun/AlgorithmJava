package atcoder.ABC._198.F;

import java.io.*;
import java.util.*;

import library.algorithm.Mint;
import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private static final Mint Mt = new Mint(()->998244353);

    private void solve() {

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