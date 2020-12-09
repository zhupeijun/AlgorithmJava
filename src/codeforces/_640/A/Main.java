package codeforces._640.A;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        List<Integer> ans = new ArrayList<>();
        int base = 1;
        while (n > 0) {
            int m = n % 10;
            if (m > 0) {
                ans.add(m * base);
            }
            n /= 10;
            base *= 10;
        }
        out.println(ans.size());
        out.printLine(ans);
    }

    private void run() {
        int T = sc.nextInt();
        for (int t = 0; t < T; ++t) {
            solve();
        }
    }

    private static MyPrintWriter out;
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

    private static class MyPrintWriter extends PrintWriter {
        MyPrintWriter(OutputStream os) {
            super(os);
        }

        public void printLine(List<Integer> a) {
            for (int i = 0; i < a.size(); ++i) {
                print(a.get(i));
                print(i == a.size() - 1 ? '\n' : ' ');
            }
        }
    }

    public static void main(String[] args) {
        out = new MyPrintWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Main().run();
        out.close();
    }
}
