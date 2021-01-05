package atcoder.ABC._161.D;

import java.io.*;
import java.util.*;

public class Main {

    private void solve() {
        Queue<Long> q = new ArrayDeque<>();
        for (int i = 1; i < 10; i++) {
            q.add((long)i);
        }

        int k = sc.nextInt();
        int n = 1;
        int ans = 0;
        while (n < k && !q.isEmpty()) {
            long u = q.poll();
            long d = u % 10;
            if (d > 0) {
                q.add(u * 10 + (d - 1));
            }
            q.add(u * 10 + d);
            if (d + 1 < 10) {
                q.add(u * 10 + (d + 1));
            }
            ++n;
        }

        out.println(q.poll());
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
