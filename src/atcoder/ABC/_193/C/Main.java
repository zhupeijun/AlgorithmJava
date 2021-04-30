package atcoder.ABC._193.C;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        long N = sc.nextLong();
        Set<Long> set = new HashSet<>();
        for (long i = 2; i <= 100000; ++i) {
            long value = i * i;
            while (value <= N) {
                set.add(value);
                value *= i;
            }
        }
        out.println(N - set.size());
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
