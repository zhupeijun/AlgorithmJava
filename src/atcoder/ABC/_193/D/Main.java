package atcoder.ABC._193.D;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int M = 10;

    private long cal(String s, int last) {
        int[] cnt = new int[10];
        for (int i = 0; i < 4; ++i) {
            ++cnt[s.charAt(i) - '0'];
        }
        ++cnt[last];
        long score = 0;
        for (int i = 1; i <= 9; ++i) {
            long v = 1;
            for (int j = 0; j < cnt[i]; ++j) {
                v *= 10;
            }
            score += v * i;
        }
        return score;
    }

    private void solve() {
        int K = sc.nextInt();
        int[] c = new int[M];
        Arrays.fill(c, K);

        String S = sc.next();
        String T = sc.next();

        int tot = 9 * K - 8;
        for (int i = 0; i < 4; ++i) {
            --c[S.charAt(i) - '0'];
            --c[T.charAt(i) - '0'];
        }

        double ans = 0;
        double sum = 0;
        for (int i = 1; i <= 9; ++i) {
            long s1 = cal(S, i);
            double p1 = (double)c[i] / tot;
            --c[i];
            for (int j = 1; j <= 9; ++j) {
                long s2 = cal(T, j);
                double p2 = (double) c[j] / (tot - 1);
                sum += p1 * p2;
                if (s1 > s2) {
                    ans += p1 * p2;
                }
            }
            ++c[i];
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
