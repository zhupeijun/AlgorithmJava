// BEGIN CUT HERE
package topcoder.SRM799;
// END CUT HERE

import java.util.*;

public class CapriciousSorting {

    private boolean check(int[] a, int cur, int mask) {
        for (int i = 1; i < a.length; ++i) {
            if (((a[i] & mask) ^ cur) < ((a[i-1] & mask) ^ cur)) {
                return false;
            }
        }
        return true;
    }

    public int count(int[] a) {
        int ans = 1;
        int cur = 0;
        int mask = 0;
        for (int k = 29; k >= 0; --k) {
            int cnt = 0;
            mask |= 1 << k;
            if (check(a, cur, mask)) {
                ++cnt;
            }

            if (check(a, cur | (1 << k), mask)) {
                cur |= (1 << k);
                ++cnt;
            }
            if (cnt == 0) return 0;
            ans *= cnt;
        }

        for (int i = 1; i < a.length; ++i) {
            if ((a[i] ^ cur) <= (a[i-1] ^ cur)) {
                return 0;
            }
        }
        return ans;
    }
}
