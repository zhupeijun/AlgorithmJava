package codeforces.E88.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int MOD = 998244353;
    private static final int N = 500005;
    private long[] frac;

    private long pow(long a, long n) {
        long ret = 1;
        long base = a;
        while (n > 0) {
            if ((n & 1) > 0) {
                ret = (ret * base) % MOD;
            }
            base = (base * base) % MOD;
            n >>= 1;
        }
        return ret;
    }

    private long inv(long a) {
        return pow(a, MOD - 2);
    }

    private void init() {
        frac = new long[N];
        frac[0] = frac[1] = 1;
        for (int i = 2; i < N; i++) {
            frac[i] = (frac[i - 1] * i) % MOD;
        }
    }

    private long c(int n, int m) {
        if (n == m || m == 0) {
            return 1;
        }

        return (((frac[n] * inv(frac[m])) % MOD) * inv(frac[n - m])) % MOD;
    }

    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (k == 1) {
            out.println(n);
            return;
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int t = n / i;
            if (t >= k) {
                ans += c(t - 1, k - 1);
                ans %= MOD;
            }
        }
        out.println(ans);
    }

    private void run() {
        init();
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            solve();
        }
    }

    private static MyWriter out;
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

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        List<Integer> nextList(int n) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(nextInt());
            }
            return list;
        }
    }

    private static class MyWriter extends PrintWriter {
        private MyWriter(OutputStream outputStream) {
            super(outputStream);
        }

        void printArray(int[] a) {
            for (int i = 0; i < a.length; ++i) {
                print(a[i]);
                print(i == a.length - 1 ? '\n' : ' ');
            }
        }

        void printlnArray(int[] a) {
            for (int v : a) {
                println(v);
            }
        }

        void printList(List<Integer> list) {
            for (int i = 0; i < list.size(); ++i) {
                print(list.get(i));
                print(i == list.size() - 1 ? '\n' : ' ');
            }
        }

        void printlnList(List<Integer> list) {
            list.forEach(this::println);
        }
    }

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}