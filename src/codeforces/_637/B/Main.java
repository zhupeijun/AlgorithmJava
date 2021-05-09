package codeforces._637.B;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private void solveCase() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int peak = 0;
        int maxPeak = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; ++i) {
            if (i > 1 && a[i - 1] > a[i - 2]  && a[i - 1] > a[i]) {
                ++peak;
            }

            if (i - k + 1 > 0 && a[i - k + 1] > a[i - k] && a[i - k + 1] > a[i - k + 2]) {
                --peak;
            }

            if (i - k + 1 >= 0 && peak > maxPeak) {
                maxPeak = peak;
                maxIdx = i - k + 1;
            }
        }
        System.out.println(String.format("%d %d", maxPeak + 1, maxIdx + 1));
    }

    private void solve() {
        int T = sc.nextInt();
        for (int i = 0; i < T; ++i) {
            solveCase();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
