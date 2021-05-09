package codeforces._706.D;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private boolean check(List<int[]> len) {
        if (len.size() == 0) return false;
        int[] last = len.get(len.size() - 1);

        if (last[0] == last[1] && last[0] % 2 == 0) {
            if (len.size() == 1) return true;
            int[] secLast = len.get(len.size() - 2);
            return Math.max(secLast[0], secLast[1]) < last[0];
        }
        return false;
    }

    private void solve() {
        int n = sc.nextInt();
        int[] a = new int[n + 2];
        for (int i = 1; i <= n; ++i) {
            a[i] = sc.nextInt();
        }

        List<int[]> len = new ArrayList<>();
        for (int j = 1; j <= n; ++j) {
            if (a[j] > a[j-1] && a[j] > a[j+1]) {
                int left = j;
                while (left - 1> 0 && a[left] > a[left-1]) {
                    --left;
                }

                int right = j;
                while (right + 1 <= n && a[right] > a[right + 1]) {
                    ++right;
                }

                int ll = j - left;
                int lr = right - j;
                if (ll > lr) {
                    len.add(new int[]{ll, lr});
                } else {
                    len.add(new int[]{lr, ll});
                }
            }
        }
        len.sort(Comparator.comparingInt((int[] l) -> l[0]).thenComparing((int[] l)-> l[1]));
        out.println(check(len) ? 1 : 0);
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