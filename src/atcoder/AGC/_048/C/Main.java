package atcoder.AGC._048.C;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] A = new int[N+2];
        int[] B = new int[N+2];
        for (int i = 1; i <= N; ++i) A[i] = sc.nextInt();
        for (int i = 1; i <= N; ++i) B[i] = sc.nextInt();
        A[0] = B[0] = 0;
        A[N+1] = B[N+1] = L+1;
        int[] C = new int[N+2];
        for (int i = 0; i < C.length; ++i) C[i] = B[i] - A[i];
        int l = 0;
        long ans = 0;
        while (l < N+1) {
            int r = l+1;
            while (C[r] != 0) ++r;
            if (r - l > 1) {
                int m1 = l;
                for (int i = l + 1; i < r; ++i) if (C[i] < 0) m1 = i;
                int m2 = r;
                for (int i = r - 1; i > l; --i) if (C[i] > 0) m2 = i;
                if (m1>m2) {
                    out.println(-1);
                    return;
                }
                if (m1 > l) {
                    Queue<Integer> q = new ArrayDeque<>();
                    q.add(m1);
                    ++ans;
                    for (int i = m1 - 1; i > l; --i) {
                        boolean exist = false;
                        while (!q.isEmpty() && A[i] + q.size() == B[q.peek()]) {
                            exist = true;
                            q.poll();
                        }
                        if (exist) {
                            ans += q.size();
                        }
                        ++ans;
                        q.add(i);
                    }
                    while (!q.isEmpty() && A[l] + q.size() == B[q.peek()]) {
                        q.poll();
                    }
                    if (!q.isEmpty()) {
                        out.println(-1);
                        return;
                    }
                }

                if (m2 < r) {
                    Queue<Integer> q = new ArrayDeque<>();
                    q.add(m2);
                    ++ans;
                    for (int i = m2 + 1; i < r; ++i) {
                        boolean exist = false;
                        while (!q.isEmpty() && A[i] - q.size() == B[q.peek()]) {
                            exist = true;
                            q.poll();
                        }
                        if (exist) {
                            ans += q.size();
                        }
                        ++ans;
                        q.add(i);
                    }
                    while (!q.isEmpty() && A[r] - q.size() == B[q.peek()]) {
                        q.poll();
                    }
                    if (!q.isEmpty()) {
                        out.println(-1);
                        return;
                    }
                }
            }
            l = r;
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

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
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

        void printArray(long[] a) {
            for (int i = 0; i < a.length; ++i) {
                print(a[i]);
                print(i == a.length - 1 ? '\n' : ' ');
            }
        }

        void println(int[] a) {
            for (int v : a) {
                println(v);
            }
        }

        void print(List<Integer> list) {
            for (int i = 0; i < list.size(); ++i) {
                print(list.get(i));
                print(i == list.size() - 1 ? '\n' : ' ');
            }
        }

        void println(List<Integer> list) {
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

    private void fill(int[][] a, int value) {
        for (int[] row : a) {
            fill(row, value);
        }
    }

    private void fill(int[] a, int value) {
        Arrays.fill(a, value);
    }

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}