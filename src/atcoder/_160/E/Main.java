package atcoder._160.E;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int x = sc.nextInt();
        int y = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();


        int[] p = new int[a];
        for (int i = 0; i < a; i++) {
            p[i] = sc.nextInt();
        }

        int[] q = new int[b];
        for (int i = 0; i < b; i++) {
            q[i] = sc.nextInt();
        }

        int[] r = new int[c];
        for (int i = 0; i < c; i++) {
            r[i] = sc.nextInt();
        }

        PriorityQueue<Integer> que = new PriorityQueue<>();
        Arrays.sort(p);
        for (int i = 0; i < x; i++) {
            que.add(p[a - 1 - i]);
        }

        Arrays.sort(q);
        for (int i = 0; i < y; i++) {
            que.add(q[b - 1 - i]);
        }

        for (int i = 0; i < c; i++) {
            if (!que.isEmpty() && r[i] > que.peek()) {
                que.poll();
                que.add(r[i]);
            }
        }

        long ans = 0;
        while (!que.isEmpty()) {
            ans += que.poll();
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
