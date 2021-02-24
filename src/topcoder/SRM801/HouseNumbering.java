// BEGIN CUT HERE
package topcoder.SRM801;
// END CUT HERE

import java.util.*;

public class HouseNumbering {
	public int[] prepareDigits(int fh, int n) {
		int[] cnt = new int[10];
		for (int i = 0; i < n; ++i) {
			int x = i * 2 + fh;
			while (x > 0) {
				++cnt[x % 10];
				x /= 10;
			}
		}
		return cnt;
	}
}
