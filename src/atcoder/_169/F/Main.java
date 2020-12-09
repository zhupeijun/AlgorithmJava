package atcoder._169.F;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;
    private static final int MOD = 998244353;

    private void solve() {
        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int[][] dp = new int[N + 1][S + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= S; j++) {
                dp[i][j] += dp[i - 1][j];
                dp[i][j] %= MOD;
                dp[i][j] += dp[i - 1][j];
                dp[i][j] %= MOD;

                if (j - A[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - A[i - 1]];
                    dp[i][j] %= MOD;
                }
            }
        }

//        for (int i = 0; i <= N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        out.println(dp[N][S]);
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