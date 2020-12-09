package atcoder._167.F;

import java.io.*;
import java.util.*;

/**
5
((((((((((
)))))(
))))))(((
)))))))(((((
)
Yes
 */

public class Main {

    private void solve() {
        int n = sc.nextInt();
        String[] s = new String[n];

        List<int[]> up = new ArrayList<>();
        List<int[]> down = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();

            int cnt = 0, dep = 0;
            for (char c : s[i].toCharArray()) {
                cnt += c == '(' ? 1 : -1;
                dep = Math.min(dep, cnt);
            }

            // left unmatched
            int left = -dep;

            // right unmatched
            int right = cnt + left;

            int remain = right - left;
            if (remain >= 0) {
                up.add(new int[] { -left , remain });
            } else {
                down.add(new int[] { -left, remain  });
            }
        }

        up.sort((a, b) -> b[0] - a[0]);
        down.sort((a, b) -> - (a[1] - a[0]) + (b[1] - b[0]));

        int cur = 0;
        boolean ans = true;
        for (int[] x : up) {
            if (cur + x[0] < 0) {
                ans = false;
                break;
            }
            cur += x[1];
        }

        for (int[] x : down) {
            if (cur + x[0] < 0) {
                ans = false;
                break;
            }
            cur += x[1];
        }

        System.out.println(cur == 0 && ans ? "Yes" : "No");
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
