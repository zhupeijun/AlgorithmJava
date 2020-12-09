package atcoder._168.E;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static final int MOD = 1000000007;

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

    private void add(Map<String, int[]> cnt, String key, int i) {
        int[] v = cnt.computeIfAbsent(key, k -> new int[]{0, 0});
        ++v[i];
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private void solve() {
        int n = sc.nextInt();
        long adt = 0;
        Map<String, int[]> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (a == 0 && b == 0) {
                ++adt;
                continue;
            }

            if (a == 0L) {
                add(cnt,"0,0", 0);
            } else if (b == 0L) {
                add(cnt, "0,0", 1);
            } else {
                if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
                    a = Math.abs(a);
                    b = Math.abs(b);
                    long g = gcd(a, b);
                    String key = (a/g) + "," + (b/g);
                    add(cnt,key, 0);
                } else {
                    a = Math.abs(a);
                    b = Math.abs(b);
                    long g = gcd(a, b);
                    String key = (b/g) + "," + (a/g);
                    add(cnt, key, 1);
                }
            }
        }

        long ans = 1;
        for (int[] v : cnt.values()) {
            ans = (ans * ((pow(2, v[0]) + pow(2, v[1]) - 1 + MOD) % MOD)) % MOD;
        }

        ans = (ans + adt - 1 + MOD) % MOD;
        out.println(ans);
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
