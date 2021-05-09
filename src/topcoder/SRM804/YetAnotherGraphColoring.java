// BEGIN CUT HERE
package topcoder.SRM804;
// END CUT HERE

import java.util.*;

public class YetAnotherGraphColoring {

    private static class RMQ {
        int n;
        int[] dat;

        RMQ(int n_) {
            n = 1;
            while (n < n_) n *= 2;
            dat = new int[2 * n - 1];
            for (int i = 0; i < 2 * n - 1; ++i) dat[i] = 0;
        }

        void update(int k, int a) {
            k += n - 1;
            // max value
            dat[k] = Math.max(a, dat[k]);
            while (k > 0) {
                k = (k - 1) / 2;
                dat[k] = Math.max(dat[k * 2 + 1], dat[k * 2 + 2]);
            }
        }

        int query(int a, int b, int k, int l, int r) {
            if (r <= a || b <= l) return 0;
            if (a <= l && r <= b) return dat[k];
            else {
                int mid = (l + r) / 2;
                int vl = query(a, b, k * 2 + 1, l, mid);
                int vr = query(a, b, k * 2 + 2, mid, r);
                return Math.max(vl, vr);
            }
        }

        int query(int a, int b) {
            return query(a, b, 0, 0, n);
        }
    }

    public int minColors(int n, int a1, int a2, int x, int y, int z, int m) {
        long[] a = new long[n];
        long[] s = new long[n];
        a[0] = a1; a[1] = a2; s[0] = a1; s[1] = a2;
        for (int i = 2; i < n; ++i) {
            a[i] = (x * a[i-1] + y * a[i-2] + z) % m;
            s[i] = a[i];
        }

        Arrays.sort(s);
        Map<Long, Integer> id = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            long v = s[i];
            if (!id.containsKey(v)) {
                id.put(v, id.size());
            }
        }

        int[] b = new int[n];
        for (int i = 0; i < n; ++i) {
            b[i] = id.get(a[i]);
        }

        int ans = 0;
        RMQ rmq = new RMQ(n+5);
        for (int i = 0; i < n; ++i) {
            int ret = rmq.query(b[i]+1, n+1);
            int c = ret + 1;
            ans = Math.max(ans, c);
            rmq.update(b[i], c);
        }

        return ans;
    }
}
