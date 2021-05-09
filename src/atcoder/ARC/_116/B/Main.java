package atcoder.ARC._116.B;

import java.io.*;
import java.util.*;

import library.algorithm.Mint;
import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final Mint Mt = new Mint(() -> 998244353);

    private void solve() {
        int N = sc.nextInt();
        int[] A = sc.nextIntArray(N);
        Arrays.sort(A);

        long cur = 0;
        long ans = 0;
        for (int i = 0; i < N; ++i) {
            long t = cur;
            if (i-1>=0) t = Mt.add(t, A[i-1]);
            t = Mt.add(t, A[i]);
            ans = Mt.add(ans, Mt.mul(t, A[i]));
            if (i-1>=0) cur = Mt.mul(Mt.add(cur, A[i-1]),2);
        }
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
        new Main().run();
        out.close();
    }
}