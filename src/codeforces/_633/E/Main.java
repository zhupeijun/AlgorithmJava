package codeforces._633.E;

import java.io.*;
import java.util.*;

public class Main {

    private static final long[][] PT = {
            {0, 0, 0},
            {1, 2, 3},
            {0, 0, 0},
            {1, 2, 3},
            {2, 3, 1},
            {3, 1, 2}
    };

    private int getPt(long k, long value) {
        long d = 1;
        long st = 0;
        for (int i = 2; i <= k; ++i) {
            d *= 4;
            st = st * 4 + 1;
        }

        if (value < st) {
            return 0;
        }

        if (value < st + d) {
            return 1;
        }

        long t = (value - (st + d)) / d;
        return (int)(t % 4) + 2;
    }

    private void solve() {
        long n = sc.nextLong() - 1;

        long part = n / 3;
        int subIdx = (int)(n % 3);

        long ans = 0;
        for (int i = 1; i <= 31; ++i) {
            int pt = getPt(i, part);
            ans += (PT[pt][subIdx]) << ((i - 1) * 2);
        }
        out.println(ans);
    }

    private void run() {
        int T = sc.nextInt();
        for (int t = 0; t < T; ++t) {
            solve();
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
        new Main().run();
        out.close();
    }
}
