package codeforces._632.C;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        long total = (long)n * (n + 1) / 2;
        Map<Long, Integer> preSum = new HashMap<>();
        long sum = 0;
        int last = -1;
        long ans = 0;
        preSum.put(0L, -1);
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (preSum.containsKey(sum)) {
                int start = preSum.get(sum) + 1;
                ans += (long) (Math.max(0, start - last)) * (n - i);
                last = Math.max(last, start);
            }
            preSum.put(sum, i);
        }
        out.println(total - ans);
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
