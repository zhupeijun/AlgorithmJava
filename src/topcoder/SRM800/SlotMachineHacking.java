// BEGIN CUT HERE
package topcoder.SRM800;
// END CUT HERE

import java.util.*;

public class SlotMachineHacking {
    public int win(String[] reels, int[] steps) {
        int n = reels.length;
        int[] cur = new int[n];
        for (int k = 0; k < 200000; ++k) {
            boolean ok = true;
            for (int i = 0; i < n; ++i) {
                cur[i] = (cur[i] + steps[i]) % reels[i].length();
                if (reels[i].charAt(cur[i]) != 'c') {
                    ok = false;
                }
            }
            if (ok) return k;
        }
        return -1;
    }
}
