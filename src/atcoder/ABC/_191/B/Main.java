package atcoder.ABC._191.B;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] A = sc.nextIntArray(N);

        List<Integer> ans = new ArrayList<>();
        for (int v : A) {
            if (v != X) {
                ans.add(v);
            }
        }

        if (ans.isEmpty()) {
            out.println();
        } else {
            out.print(ans);
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
        cu = new CommonUtils();
        new Main().run();
        out.close();
    }
}
