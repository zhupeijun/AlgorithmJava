package atcoder.ARC._115.C;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int[] A = new int[N];

        A[0] = 1;
        for (int i = 1; i < N; ++i) {
            int x = i+1;
            Set<Integer> s = new HashSet<>();
            for (int k = 1; k * k <= N; ++k) {
                if (x % k == 0) {
                    s.add(A[k-1]);
                    s.add(A[x/k-1]);
                }
            }
            int t = 1;
            while (s.contains(t)) {
                ++t;
            }
            A[i] = t;
        }
        out.printArray(A);
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