package codeforces._648.D;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;

    private int n;
    private int m;
    private char[][] g;
    private int gN;
    private int bN;

    private static final int[][] DIR = {{0,1},{1,0},{-1,0},{0,-1}};

    private boolean isValid(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    private void dfs(int i, int j) {
        if (g[i][j] == 'B') {
            ++bN;
        } else if (g[i][j] == 'G') {
            ++gN;
        }

        g[i][j] = '#';

        for (int[] d : DIR) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (isValid(ni, nj) && g[ni][nj] != '#') {
                dfs(ni, nj);
            }
        }
    }
    
    private void solve() {
        n = sc.nextInt();
        m = sc.nextInt();
        
        g = sc.nextCharArray(n, m);
        gN = bN = 0;

        int gt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'G') {
                    ++gt;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'B') {
                    for (int[] d : DIR) {
                        int ni = i + d[0];
                        int nj = j + d[1];

                        if (isValid(ni, nj) && g[ni][nj] == '.') {
                            g[ni][nj] = '#';
                        }
                    }
                }
            }
        }

        if (g[n - 1][m - 1] != '#') {
            dfs(n - 1, m - 1);
        }

        if (gN != gt || bN > 0) {
            out.println("No");
        } else {
            out.println("Yes");
        }
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            solve();
        }
    }

    private static MyWriter out;
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

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        int[][] nextIntArray(int n, int m) {
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            return a;
        }

        long[][] nextLongArray(int n, int m) {
            long[][] a = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = nextLong();
                }
            }
            return a;
        }

        List<Integer> nextList(int n) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(nextInt());
            }
            return list;
        }

        List<Long> nextLongList(int n) {
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(nextLong());
            }
            return list;
        }

        char[] nextCharArray(int n) {
            return sc.next().toCharArray();
        }

        char[][] nextCharArray(int n, int m) {
            char[][] c = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < m; j++) {
                    c[i][j] = s.charAt(j);
                }
            }
            return c;
        }
    }

    private static class MyWriter extends PrintWriter {
        private MyWriter(OutputStream outputStream) {
            super(outputStream);
        }

        void printArray(int[] a) {
            for (int i = 0; i < a.length; ++i) {
                print(a[i]);
                print(i == a.length - 1 ? '\n' : ' ');
            }
        }

        void printlnArray(int[] a) {
            for (int v : a) {
                println(v);
            }
        }

        void printList(List<Integer> list) {
            for (int i = 0; i < list.size(); ++i) {
                print(list.get(i));
                print(i == list.size() - 1 ? '\n' : ' ');
            }
        }

        void printlnList(List<Integer> list) {
            list.forEach(this::println);
        }
    }

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}