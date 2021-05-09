package codeforces._647.E;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;

    private static final int MOD = 1000000007;

    private long pow(long a, int n) {
        long ret = 1;
        long base = a;
        while (n > 0) {
            if ((n & 1) > 0) {
                ret = (ret * base) % MOD;
            }
            base = (base * base) % MOD;
            n >>= 1;
        }
        return ret;
    }

    private void solve() {
        int n = sc.nextInt();
        int p = sc.nextInt();
        List<Integer> k = sc.nextList(n);

        if (p == 1) {
            out.println(n % 2 == 0 ? 0 : 1);
            return;
        }

        k.sort(Collections.reverseOrder());

        long x = 1;
        int pk = k.get(0);
        boolean over = false;
        for (int i = 1; i < n; ++i) {
            if (k.get(i) != pk) {
                int m = pk - k.get(i);

                long t = x;
                // skip when x = 0 or will cause m times loop
                if (!over && x > 0) {
                    for (int j = 0; j < m; ++j) {
                        x *= p;
                        if (x >= n) {
                            over = true;
                            break;
                        }
                    }
                }

                if (over) {
                    x = (t * pow(p, m)) % MOD;
                }

                pk = k.get(i);
            }
            if (!over) {
                x = Math.abs(x - 1);
            } else {
                x = (x - 1 + MOD) % MOD;
            }
        }
        out.println((x * pow(p, pk)) % MOD);
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

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
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