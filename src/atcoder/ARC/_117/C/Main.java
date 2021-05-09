package atcoder.ARC._117.C;

import java.io.*;
import java.util.*;

import library.algorithm.Mint;
import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final String V = "BWR";
    private static final int P = 3;
    private static final Mint Mt = new Mint(()->P);

    long[] fact = {1,1,2,3};

    private long lucas(int n, int m) {
        if (m == 0) return 1;
        return lucas(n/P,m/P) * comb(n%P, m%P) % P;
    }

    private long comb(int n, int m) {
        return n < m ? 0 : Mt.div(fact[n], Mt.mul(fact[m], fact[n-m]));
    }

    private void solve() {

        int N = sc.nextInt();
        String s = sc.next();
        long ans = 0;
        for (int i = 0; i < N; ++i) {
            int v = V.indexOf(s.charAt(i));
            ans = Mt.add(ans, Mt.mul(v, lucas(N-1, i)));
        }

        ans = Mt.mul(ans, Mt.pow(2, N-1));
        out.println(V.charAt((int)ans));
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