package codeforces._664.D;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int n = sc.nextInt();
        int d = sc.nextInt();
        int m = sc.nextInt();

        int[] a = sc.nextIntArray(n);

        List<Long> up = new ArrayList<>();
        List<Long> down = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] > m) {
                up.add((long)a[i]);
            } else {
                down.add((long)a[i]);
            }
        }

        Collections.sort(up, Collections.reverseOrder());
        Collections.sort(down);

        long[] upSum = new long[up.size()];
        for (int i = 0; i < up.size(); ++i) {
            upSum[i] = i == 0 ? up.get(i) : up.get(i) + upSum[i - 1];
        }

        long[] downSum = new long[down.size()];
        for (int i = 0; i < down.size(); ++i) {
            downSum[i] = i == 0 ? down.get(i) : down.get(i) + downSum[i - 1];
        }

        long ans = 0;
        for (long v : down) {
            ans += v;
        }

        if (up.size() > 0) {
            ans += up.get(0);
        }

        for (int i = 1; i < up.size(); ++i) {
            long cut = (long)i * d;
            cut -= up.size() - i - 1;
            if (cut <= 0) {
                long cur = upSum[i];
                if (down.size() > 0) {
                    cur += downSum[down.size() - 1];
                }
                ans = Math.max(cur, ans);
            } else if (cut <= down.size()) {
                long cur = upSum[i];
                cur += downSum[down.size() - 1];
                cur -= downSum[(int)(cut - 1)];
                ans = Math.max(cur, ans);
            }
        }
        out.println(ans);
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

    private <T> List<List<T>> createGraph(int n) {
        List<List<T>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}