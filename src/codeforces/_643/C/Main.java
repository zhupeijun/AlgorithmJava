package codeforces._643.C;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        int m = B + C + 2;
        long[] cnt = new long[m];
        for (int x = A; x <= B; ++x) {
            cnt[x + B] += 1;
            cnt[x + C + 1] -= 1;
        }

        long ans = 0;
        for (int i = 0; i < m; ++i) {
            cnt[i] = i == 0 ? cnt[i] : cnt[i] + cnt[i - 1];
            ans += Math.max(0, Math.min(D - C + 1, i - C)) * cnt[i];
        }
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
