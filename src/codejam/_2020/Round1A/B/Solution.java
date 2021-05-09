package codejam._2020.Round1A.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private Scanner sc = new Scanner(System.in);

    private long c(long n, long k) {
        long result = 1;
        for (int i = 1; i <= k; ++i) {
            result = result * (n - i + 1) / i;
        }
        return result;
    }

    private void solve() {
        int N = sc.nextInt();
        long sum = 1;
        int r = 0;
        int c = 0;

        List<int[]> path = new ArrayList<>();
        path.add(new int[] { r + 1, c + 1 });

        while (sum < N) {
            int dr = r + 1;
            int dc = (dr % 2 == 0) ? c + 1 : c;

            long total = 0;
            for (int i = 1; i <= dc; ++i) {
                total += c(dr, i);
            }

            if (sum + total > N) {
                if (c == 0) {
                    path.add(new int[] {r + 2, c + 1});
                    sum += 1;
                    r = r + 1;
                } else {
                    path.add(new int[] {r + 1, c});
                    sum += c(r, c - 1);
                    c = c - 1;
                }
            } else {
                path.add(new int[] {dr + 1, dc + 1});
                sum += c(dr, dc);
                r = dr;
                c = dc;
            }
        }

        for (int[] p : path) {
            System.out.println(String.format("%d %d", p[0], p[1]));
        }
    }

    private void run() {
        int T = sc.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.println(String.format("Case #%d:", i));
            solve();
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
