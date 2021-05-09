package codechef.MARCH21B.COLGLF4;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private void solve() {
        int N = sc.nextInt();
        int E = sc.nextInt();
        int H = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        long ans = -1;
        for (long i = 0; i <= N; ++i) {
            long RE = E - i;
            long RH = H - i;

            if (RE < 0 || RH < 0) {
                break;
            }

            if (A < B) {
                long j = Math.min(N - i, RE/2);
                long k = Math.min(N - i - j, RH/3);

                if (i + j + k == N) {
                    long price = C * i + A * j + B * k;
                    if (ans == -1 || ans > price) {
                        ans = price;
                    }
                }
            } else {
                long k = Math.min(N - i, RH/3);
                long j = Math.min(N - i - k, RE/2);

                if (i + j + k == N) {
                    long price = C * i + A * j + B * k;
                    if (ans == -1 || ans > price) {
                        ans = price;
                    }
                }
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