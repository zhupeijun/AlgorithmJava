// BEGIN CUT HERE
package topcoder.SRM804;
// END CUT HERE

import java.util.*;
import java.util.function.IntSupplier;

public class UnluckyNumber {

    private static final Mint Mt = new Mint();

    public static class Mint {
        private final static int DEFAULT = 1000_000_007;
        private IntSupplier modVal = () -> DEFAULT;

        public Mint() {
        }

        public Mint(int value) {
            this.modVal = () -> value;
        }

        public Mint(IntSupplier modVal) {
            this.modVal = modVal;
        }

        public long add(long a, long b) { return (((a + b) % mod() + mod()) % mod());}
        public long sub(long a, long b) { return (((a - b) % mod() + mod()) % mod()); }
        public long mul(long a, long b) { return (((a * b) % mod() + mod()) % mod()); }
        public long div(long a, long b) { return (((a * inv(b)) % mod() + mod()) % mod()); }
        public long inv(long a) { return pow(a, mod() - 2); }
        public long pow(long a, int n) {
            long ret = 1;
            while (n > 0) {
                if ((n & 1) > 0) { ret = mul(ret, a); }
                a = mul(a, a);
                n >>= 1;
            }
            return ret;
        }

        private int mod() {
            return modVal.getAsInt();
        }
    }

    private void dfs(int u, List<List<Integer>> g, int[] color, int[] cf) {
        ++cf[1];
        for (int v : g.get(u)) {
            if (color[v] == -1) {
                color[v] = color[u]^1;
                dfs(v, g, color, cf);
            } else {
                if (color[u] == color[v]) {
                    cf[0] = 1;
                }
            }
        }
    }

    public int numberOfColourings(int n, int m, int k, int z, int[] x, int[] y) {

        long tot = 0;
        int maskMax = 1 << m;
        for (int mask = 0; mask < maskMax; ++mask) {
            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i < n; ++i) g.add(new ArrayList<>());
            int edge = 0;
            for (int j = 0; j < m; ++j) {
                if ((mask & 1 << j) > 0) {
                    int u = x[j]-1, v = y[j] - 1;
                    g.get(u).add(v);
                    g.get(v).add(u);
                    ++edge;
                }
            }

            long cnt = 1;
            int[] color = new int[n]; Arrays.fill(color, -1);
            for (int i = 0; i < n; ++i) {
                if (color[i] == -1) {
                    color[i] = 0;
                    int[] cf = new int[2];
                    dfs(i, g, color, cf);
                    if (cf[1] == 1) {
                        cnt = Mt.mul(cnt, k);
                    } else {
                        int max = Math.min(z-1, k);
                        int min = Math.max(1, z-k);
                        if(cf[0] == 0) {
                            cnt = Mt.mul(cnt, Math.max(0, max - min + 1));
                        } else {
                            if (z % 2 == 1 || (z/2 > max || z/2 < min)) cnt = 0;
                        }
                    }
                }
            }

            if (edge % 2 == 0) {
                tot = Mt.add(tot, cnt);
            } else {
                tot = Mt.sub(tot, cnt);
            }
        }
        return (int)tot;
    }

    public static void main(String[] args) {
        int n = 18;
        int m = 17;
        int k = 485143292;
        int z = 789442323;
        int[] x = {11, 9, 14, 17, 8, 13, 2, 2, 12, 15, 1, 3, 11, 6, 14, 1, 14};
        int[] y = {15, 10, 7, 2, 5, 9, 1, 11, 13, 16, 5, 7, 4, 8, 3, 13, 18};
        System.out.println(new UnluckyNumber().numberOfColourings(n, m, k, z, x, y));
    }
}
