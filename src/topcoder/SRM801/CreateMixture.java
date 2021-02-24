// BEGIN CUT HERE
package topcoder.SRM801;
// END CUT HERE

import java.util.*;

public class CreateMixture {
	public int[] mix(int con) {
		if (con == 0) {
			return new int[0];
		}

		if (con == 1000) {
			int[] ret = new int[10];
			Arrays.fill(ret, -1);
			ret[0] = 1;
			return ret;
		}

		int a = con % 10;
		int[] ret = new int[30];
		for (int i = 0; i < a; ++i) {
			ret[i] = 1;
		}

		int b = (con / 10) % 10;
		for (int i = 0; i < b; ++i) {
			ret[i + 10] = 1;
		}
		ret[19] = 2;

		int c = (con / 100) % 10;
		for (int i = 0; i < c; ++i) {
			ret[i + 20] = 1;
		}
		ret[29] = 3;

		return ret;
	}
}
