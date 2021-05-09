package atcoder.ABC._199.B;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int[] A = sc.nextIntArray(N);
        int[] B = sc.nextIntArray(N);

        int ans = 0;
        for (int i = 1; i <= 1000; ++i) {
            boolean ok = true;
            for (int j = 0; j < N; ++j) {
                if (i > B[j] || i < A[j]) {
                    ok = false; break;
                }
            }
            if (ok) ++ans;
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
        cu = new CommonUtils();
        new Main().run();
        out.close();
    }
}
