package codeforces._645.C;

import java.io.*;
import java.util.*;

public class Main2 {
    private static final int[][] g = new int[100][100];

    List<List<Set<Integer>>> s = new ArrayList<>();
    void dfs(int u, int v) {
        Set<Integer> s1 = s.get(u - 1).get(v);
        Set<Integer> s2 = s.get(u).get(v - 1);

        Set<Integer> ns = s.get(u).get(v);
        for (int x : s1) {
            ns.add(x + g[u][v]);
        }

        for (int x : s2) {
            ns.add(x + g[u][v]);
        }

    }

    private void solve() {


        int cur = 1;
        for (int i = 0; i < 100; ++i) {
            g[0][i] = cur;
            cur += i + 1;
        }

        for (int i = 1; i < 99; ++i) {
            for (int j = 0; j < 99; ++j) {
                g[i][j] = g[i - 1][j + 1] + 1;
            }
        }


        int n = 100;
        for (int i = 0; i < n; i++) {
            s.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                s.get(i).add(new HashSet<>());
            }
        }

        int sum = 0;
        for (int i = 3; i < n; i++) {
            sum += g[3][i];
            s.get(3).get(i).add(sum);
        }

        sum = 0;
        for (int i = 3; i < n; i++) {
            sum += g[i][3];
            s.get(i).get(3).add(sum);
        }

        System.out.println(Arrays.deepToString(g));

        for (int i = 4; i < 20; i++) {
            for (int j = 4; j < 20; j++) {
                dfs(i, j);
            }
        }

        for (int i = 0; i < 20; ++i) {
            for (int j = 0; j < 20; ++j) {
                Set<Integer> ns = s.get(i).get(j);
//                List<Integer> t = new ArrayList<>(ns);
//                Collections.sort(t);
//                System.out.println(i + " " + j + " " + ns.size() + " " + t.toString());
                System.out.print(ns.size() + " ");
            }
            System.out.println();
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
        new Main2().run();
        out.close();
    }
}
