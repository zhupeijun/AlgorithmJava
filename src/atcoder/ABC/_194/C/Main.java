package atcoder.ABC._194.C;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int[] A = sc.nextIntArray(N);

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            cnt.put(A[i], cnt.getOrDefault(A[i], 0) + 1);
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            cnt.put(A[i], cnt.get(A[i]) - 1);

            for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
                int v = e.getKey();
                int c = e.getValue();

                long d = v - A[i];
                ans += d * d * c;
            }
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