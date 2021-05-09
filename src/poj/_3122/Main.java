package poj._3122;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;

    private static final Scanner sc = new Scanner(System.in);

    private boolean check(double mid, int[] ri, int M) {
        int tot = 0;
        for (int v : ri) {
            double area = Math.PI * v * v;
            tot += area / mid;
            if (tot >= M) return true;
        }
        return false;
    }

    private void solve() {
        int N = sc.nextInt();
        int F = sc.nextInt();

        int[] ri = new int[N];
        for (int i = 0; i < N; ++i) {
            ri[i] = sc.nextInt();
        }

        double l = 0, r = Math.PI * 10005 * 10005;
        while (Math.abs(l - r) > 0.00001) {
            double mid = (l + r) / 2;
            if (check(mid, ri, F + 1)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        System.out.printf("%f%n", l);
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            solve();
        }
    }
    public static void main(String[] args) {
        new Main().run();
    }
}