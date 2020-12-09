package codeforces.E87.B;

import java.io.*;
import java.util.*;

public class Main {
    private boolean check(int[] cnt) {
        for (int v : cnt) {
            if (v == 0) {
                return false;
            }
        }
        return true;
    }

    private void solve() {
        String s = sc.next();

        int prev = 0;
        int[] cnt = new int[3];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            ++cnt[s.charAt(i) - '1'];
            while (prev <= i && check(cnt)) {
                ans = Math.min(ans, i - prev + 1);
                --cnt[s.charAt(prev++) - '1'];
            }
        }
        out.println(ans == Integer.MAX_VALUE ? 0 : ans);
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
