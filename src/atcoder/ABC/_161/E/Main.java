package atcoder.ABC._161.E;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int N = sc.nextInt();
        int K = sc.nextInt();
        int C = sc.nextInt() + 1;

        String s = sc.next();

        int k = 0;
        int[] l = new int[K];
        for (int i = 0; i < N && k < K; ++i) {
            if (s.charAt(i) == 'o' && (k == 0 || l[k - 1] + C <= i)) {
                l[k++] = i;
            }
        }
        int[] r = new int[K];
        k = K - 1;
        for (int i = N - 1; i >= 0 && k >= 0; --i) {
            if (s.charAt(i) == 'o' && (k == K - 1 || i + C <= r[k + 1])) {
                r[k--] = i;
            }
        }

        for (int i = 0; i < K; i++) {
            if (l[i] == r[i]) {
                out.println(l[i] + 1);
            }
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
        new Main().solve();
        out.close();
    }
}
