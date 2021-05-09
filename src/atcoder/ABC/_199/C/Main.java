package atcoder.ABC._199.C;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void swap(char[] a, int i, int j) {
        char t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private int tr(int i, int N, int rev) {
        if (rev == 0) return i;
        else {
            if (i < N) return N+i;
            else return i-N;
        }
    }

    private void solve() {
        int N = sc.nextInt();
        String S = sc.next();
        int Q = sc.nextInt();

        char[] c = S.toCharArray();
        int rev = 0;
        while ((Q--) > 0) {
            int T = sc.nextInt();
            int A = tr(sc.nextInt() - 1, N, rev);
            int B = tr(sc.nextInt() - 1, N, rev);

            if (T == 1) {
                swap(c, A, B);
            } else {
                rev ^= 1;
            }
        }

        String ans = String.valueOf(c);
        if (rev == 0) {
            out.println(ans);
        } else {
            out.println(ans.substring(N) + ans.substring(0, N));
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
