package atcoder.ARC._117.A;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int A = sc.nextInt();
        int B = sc.nextInt();
        int M = A + B;
        int[] ans = new int[M];

        if (A > B) {
            int sum = 0;
            for (int i = 0; i < A; ++i) {
                ans[i] = i + 1;
                sum += ans[i];
            }
            for (int j = 0; j < B-1; ++j) {
                ans[j+A] = -(j+1);
                sum += ans[j+A];
            }
            ans[A+B-1] = -sum;
        } else if (B > A) {
            int sum = 0;
            for (int i = 0; i < B; ++i) {
                ans[i] = -(i+1);
                sum += ans[i];
            }
            for (int j = 0; j < A-1; ++j) {
                ans[j+B] = j+1;
                sum += ans[j+B];
            }
            ans[A+B-1] = -sum;
        } else {
            for (int i = 0; i < A; ++i) {
                ans[i] = (i+1);
                ans[i+A] = -(i+1);
            }
        }

        out.printArray(ans);
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