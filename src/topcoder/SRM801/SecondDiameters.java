// BEGIN CUT HERE
package topcoder.SRM801;
// END CUT HERE

import java.util.*;

public class SecondDiameters {

	private int getDist(int x1, int y1, int x2, int y2) {
		int dx = x1 - x2;
		int dy = y1 - y2;
		return dx * dx + dy * dy;
	}

	public long getSecondDiameters(int[] X, int[] Y) {
		int n = X.length;
		List<int[]> dist = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			for (int j = i; j < n; ++j) {
				dist.add(new int[] { getDist(X[i], Y[i], X[j], Y[j]), i, j });
			}
		}

		long ans = 0;
		int m = dist.size();
		dist.sort(Comparator.comparingInt(v->v[0]));
		for (int i = 0; i < n; ++i) {
			int max = -1;
			for (int j = m - 1; j >= 0; --j) {
				int[] t = dist.get(j);
				if (t[1] == i || t[2] == i) {
					continue;
				}

				if (max == -1 || max == t[0]) {
					max = t[0];
				} else {
					ans += t[0];
					break;
				}
			}
		}
		return ans;
	}
}
