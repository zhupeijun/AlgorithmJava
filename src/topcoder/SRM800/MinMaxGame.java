// BEGIN CUT HERE
package topcoder.SRM800;
// END CUT HERE

import java.util.*;

public class MinMaxGame {
    public int lastNumber(int[] A) {
        int n = A.length;
        if (n % 2 == 0) {
            return Math.min(A[0], A[n-1]);
        } else {
            return Math.max(A[0], A[n-1]);
        }
    }
}
