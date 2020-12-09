package codeforces._632.F;

import java.io.*;
import java.util.*;

public class Main {

    private List<Integer> sieve(int n) {
        List<Integer> ret = new ArrayList<>();
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i <= n; ++i) {
            if (prime[i]) {
                ret.add(i);
                for (int j = 2; j * i <= n; ++j) {
                    prime[i * j] = false;
                }
            }
        }
        return ret;
    }

    private void solve() {
        int n = sc.nextInt();
        List<Integer> pl = sieve(n);

        int[] ans = new int[n + 1];

        int pn = pl.size();
        for (int i = 1; i <= pn + 1; ++i) {
            ans[i] = 1;
        }

        int j = pn + 2;
        int cur = 2;
        while (j <= n) {
            for (int p : pl) {
                if (cur * p > n || j > n) {
                    break;
                }

                ans[j++] = cur;
                if (cur % p == 0) {
                    break;
                }
            }
            ++cur;
        }

        for (int i = 2; i <= n; ++i) {
            out.print(ans[i]);
            out.print(i == n ? '\n' : ' ');
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

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }
    }

    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().solve();
        out.close();
    }
}
