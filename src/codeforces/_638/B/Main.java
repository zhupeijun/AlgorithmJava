package codeforces._638.B;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(a[i])) {
                idx.add(a[i]);
                set.add(a[i]);
            }
        }

        if (idx.size() > k) {
            out.println(-1);
            return;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                ans.add(j >= idx.size() ? 1 : idx.get(j));
            }
        }

        int m = ans.size();
        out.println(m);
        for (int i = 0; i < m; ++i) {
            out.print(ans.get(i));
            out.print(i == m - 1 ? '\n' : ' ');
        }
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
