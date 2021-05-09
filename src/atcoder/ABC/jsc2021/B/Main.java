package atcoder.ABC.jsc2021.B;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<Integer> A = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            A.add(sc.nextInt());
        }

        Set<Integer> B = new HashSet<>();
        for (int i = 0; i < M; ++i) {
            B.add(sc.nextInt());
        }

        final int T = 1000;
        List<Integer> ans = new ArrayList<>();
        for (int j = 1; j <= T; ++j) {
            if ((A.contains(j) && !B.contains(j)) || 
                (!A.contains(j) && B.contains(j))) {
                ans.add(j);
            }
        }

        out.print(ans);
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
