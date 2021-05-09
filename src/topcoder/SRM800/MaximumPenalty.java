// BEGIN CUT HERE
package topcoder.SRM800;
// END CUT HERE

import java.util.*;

public class MaximumPenalty {
    private long cal(int[] P, int k, int t) {
        long ret = 0;
        for (int i = 3; i >= 0; --i) {
            ret = ret * t + P[4 * k + i];
        }
        return ret;
    }

    private boolean check(int[][] L, int[] P, long X, int[] ans, int sum) {
        int n = L.length;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            boolean exist = false;
            for (int j = 0; j < n; ++j) {
                if (used[j]) continue;
                int k = L[j][1];
                int v = L[j][0];
                if (cal(P, k, sum) <= X) {
                    used[j] = true;
                    sum -= v;
                    ans[n-1-i] = k;
                    exist = true;
                    break;
                }
            }
            if (!exist) return false;
        }
        return true;
    }

    public int[] schedule(int[] L, int[] P) {
        int n = L.length;
        int sum = Arrays.stream(L).sum();
        int[][] LL = new int[n][2];
        for (int i = 0; i < n; ++i) {
            LL[i][0] = L[i];
            LL[i][1] = i;
        }
        Arrays.sort(LL, Comparator.comparingInt(v -> v[0]));

        long l = 0, r = Long.MAX_VALUE;
        int[] ans = new int[n];
        while (l <= r) {
            long mid = 0;
            mid += l / 2;
            mid += r / 2;
            mid += l % 2 == 1 && r % 2 == 1 ? 1 : 0;

            int[] tmp = new int[n];
            if (check(LL, P, mid, tmp, sum)) {
                System.arraycopy(tmp, 0, ans, 0, tmp.length);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
