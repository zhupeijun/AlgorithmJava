package atcoder.ARC._116.C;

import java.io.*;
import java.util.function.Function;

import library.algorithm.Mint;
import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final Mint Mt = new Mint(()->998244353);
    private static final int MAX = 300005;

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] a = new long[MAX]; a[0] = 1;
        for (int i = 1; i < MAX; ++i) a[i] = Mt.mul(a[i-1], i);

        Function<Integer, Long> cal = (cnt) -> {
            if (cnt == 0) return 1L;
            int n = N-1+cnt;
            int m = cnt;
            return Mt.div(a[n], Mt.mul(a[m], a[n-m]));
        };

        long ans = 0;
        for (int i = 1; i <= M; ++i) {
            long k = 2;
            long x = i;
            long t = 1;
            while (k * k <= x) {
                int cnt = 0;
                while (x % k == 0) {
                    x /= k;
                    ++cnt;
                }
                t = Mt.mul(t, cal.apply(cnt));
                ++k;
            }
            if (x > 1) t = Mt.mul(t, cal.apply(1));
            ans = Mt.add(ans, t);
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