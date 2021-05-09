package codeforces.E85.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final int M = 32000000;
    private static final long MOD = 998244353L;
    private static final int C = 64;
    private List<Integer> prime;
    private long D;
    private List<Long> fac;
    private long[][] cmemo;

    private void init() {
        prime = new ArrayList<>();
        boolean[] is = new boolean[M];
        Arrays.fill(is, true);
        is[0] = is[1] = false;
        for (int i = 2; i < M; ++i) {
            if (is[i]) {
                prime.add(i);
                for(int j = i; (long)j * i < M; ++j) {
                    is[i * j] = false;
                }
            }
        }

        fac = new ArrayList<>();
        for (int p : prime) {
            while (D % p == 0) {
                fac.add((long)p);
                D /= p;
            }
        }

        if (D > 1) {
            fac.add(D);
        }

        cmemo = new long[C][C];
        for (int i = 1; i < C; i++) {
            for (int j = 0; j <= i; j++) {
                c(i, j);
            }
        }
    }

    private long c(int n, int m) {
        if (n == m || m == 0) {
            return 1;
        }

        if (cmemo[n][m] != 0) {
            return cmemo[n] [m];
        }
        cmemo[n][m] = (c(n - 1, m - 1) + c(n - 1, m)) % MOD;
        return cmemo[n][m];
    }

    private void query() {
        long u = sc.nextLong();
        long v = sc.nextLong();

        Map<Long, Integer> down = new HashMap<>();
        Map<Long, Integer> up = new HashMap<>();

        int upN = 0, downN = 0;
        for (long p : fac) {
            int cu = 0;
            if (u % p == 0 ) {
                u /= p;
                cu = 1;
            }

            int cv = 0;
            if (v % p == 0) {
                v /= p;
                cv = 1;
            }
            if (cu > cv) {
                down.put(p, down.getOrDefault(p, 0) + 1);
                downN += 1;
            } else if (cv > cu) {
                up.put(p, up.getOrDefault(p, 0) + 1);
                upN += 1;
            }
        }

        long ans = 1;
        for(int cnt : up.values()) {
            ans = (ans * c(upN, cnt)) % MOD;
            upN -= cnt;
        }

        for (int cnt : down.values()) {
            ans = (ans * c(downN, cnt)) % MOD;
            downN -= cnt;
        }

        out.println(ans);
    }

    private void solve() {
        D = sc.nextLong();
        init();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            query();
        }
    }

    private static PrintWriter out;
    private static MyScanner sc;

    private static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        private MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().solve();
        out.close();
    }
}