package atcoder.ARC._114.A;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int M = 51;

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private void solve() {
        boolean[] isPrime = new boolean[M];
        Arrays.fill(isPrime, true); isPrime[0] = isPrime[1] = false;
        for (int i = 2; i < M; ++i) {
            if (isPrime[i]) {
                for (int j = 2; j * i < M; ++j) {
                    isPrime[i*j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < M; ++i) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        int N = sc.nextInt();
        int[] X = sc.nextIntArray(N);

        int pn = primes.size();
        int m = 1 << pn;
        long ans = Long.MAX_VALUE;
        for (int mask = 0; mask < m; ++mask) {
            long val = 1;
            for (int k = 0; k < pn; ++k) {
                if ((mask & (1 << k)) > 0) {
                    val *= primes.get(k);
                }
            }

            boolean ok = true;
            for (int v : X) {
                if (gcd(v, val) == 1) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                ans = Math.min(ans, val);
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