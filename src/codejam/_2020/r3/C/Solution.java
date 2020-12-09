package codejam._2020.r3.C;

import java.util.*;

public class Solution {
    private static final Scanner sc = new Scanner(System.in);

    private void solve() {
        int N = sc.nextInt();
        int D = sc.nextInt();
        long[] A = new long[N];

        Map<Long, Integer> c = new HashMap<>();
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }


        for (int i = 0; i < D; ++i) {

        }

    }

    private void run() {
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            System.out.print(String.format("Case #%d: ", t));
            solve();
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
