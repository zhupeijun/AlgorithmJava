package atcoder.ARC._113.B;

import java.io.*;
import java.util.*;

import library.algorithm.Mint;
import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();


        List<Long> lp = new ArrayList<>();
        long X = A % 10;
        for (int i = 0; i < 15; ++i) {
            long R = X % 10;
            if (lp.contains(R)) {
                break;
            }
            lp.add(R);
            X = (X * A) % 10;
        }

        final Mint MT = new Mint(lp.size());
        int D = (int)MT.pow(B, C);
        out.println(lp.get((D-1 + lp.size()) % lp.size()));
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
