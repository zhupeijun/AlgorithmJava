package atcoder.ABC.jsc2021.F;

import java.io.*;
import java.util.*;

import library.basic.*;
import library.algorithm.Seg;

public class Main {
    private static final boolean N_CASE = false;
    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();

        int[] a = new int[N];
        int[] b = new int[M];
        int[][] qs = new int[Q][3];
        List<Integer> vals = new ArrayList<>();
        for (int i = 0; i < Q; ++i) {
            for (int j = 0; j < 3; ++j) {
                qs[i][j] = sc.nextInt();
            }
            vals.add(qs[i][2]);
        }

        Collections.sort(vals);
        Map<Integer, Integer> id = new HashMap<>();
        id.put(0, id.size());
        for (int x : vals) {
            if (!id.containsKey(x)) {
                id.put(x, id.size());
            }
        }

        int m = id.size();
        Seg sa = new Seg(m);
        Seg sb = new Seg(m);
        Seg na = new Seg(m);
        Seg nb = new Seg(m);

        List<Long> res = new ArrayList<>();
        long ans = 0;

        na.add(0, 1, N);
        nb.add(0, 1, M);
        for (int i = 0; i < Q; ++i) {
            int T = qs[i][0];
            int X = qs[i][1]-1;
            int Y = qs[i][2];

            if (T == 1) {
                int oldVal = a[X];
                int oldId = id.get(oldVal);
                ans -= sb.sum(oldId, m);
                ans -= (long)oldVal * nb.sum(0, oldId);
                sa.add(oldId, oldId+1, -oldVal);
                na.add(oldId, oldId+1, -1);

                a[X] = Y;
                int newId = id.get(Y);
                sa.add(newId, newId+1, Y);
                na.add(newId, newId+1, 1);
                ans += sb.sum(newId, m);
                ans += (long)Y * nb.sum(0, newId);
            } else {
                int oldVal = b[X];
                int oldId = id.get(oldVal);
                ans -= sa.sum(oldId, m);
                ans -= (long)oldVal * na.sum(0, oldId);
                sb.add(oldId, oldId+1, -oldVal);
                nb.add(oldId, oldId+1, -1);

                b[X] = Y;
                int newId = id.get(Y);
                sb.add(newId, newId+1, Y);
                nb.add(newId, newId+1, 1);
                ans += sa.sum(newId, m);
                ans += (long)Y * na.sum(0, newId);
            }
            res.add(ans);
        }

        out.println(res);
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            solve();
        }
    }

    private static MyWriter out;
    private static MyScanner sc;
    private static CommonUtils cu;

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        cu = new CommonUtils();
        new Main().run();
        out.close();
    }
}
