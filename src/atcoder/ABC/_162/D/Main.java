package atcoder.ABC._162.D;

import java.io.*;
import java.util.*;

public class Main {
    private void solve() {
        int n = sc.nextInt();
        String s = sc.next();

        final int M = 26;
        int[][] r = new int[M][n];
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                for (int j = 0; j < M; j++) {
                    r[j][i] = r[j][i - 1];
                }
            }

            int k = s.charAt(i) - 'A';
            ++r[k][i];
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            char ci = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char cj = s.charAt(j);

                if (ci == cj) {
                    continue;
                }

                char ck;
                if (ci == 'R') {
                    ck = cj == 'G' ? 'B' : 'G';
                } else if (ci == 'G'){
                    ck = cj == 'R' ? 'B' : 'R';
                } else {
                    ck = cj == 'G' ? 'R' : 'G';
                }

                int t = r[ck - 'A'][n - 1] - r[ck - 'A'][j];
                int rk = j + (j - i);
                if (rk < n && s.charAt(rk) == ck) {
                    --t;
                }
                ans += t;
            }
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
