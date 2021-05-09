package atcoder.ARC._112.B;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private long[] create(long a, long b) {
        return new long[] { Math.min(a, b), Math.max(a, b) };
    }

    private void solve() {
        long B = sc.nextLong();
        long C = sc.nextLong();

        List<long[]> seg = new ArrayList<>();
        seg.add(create(B-C/2, B));
        seg.add(create(-B + (C - 1)/2, -B));
        seg.add(create(-B - (C - 1)/2, -B));

        if (C >= 2) {
            seg.add(create(B + (C - 2) / 2, B));
        }

        seg.sort((v1, v2) -> {
            if (v1[0] == v2[0]) return Long.compare(v1[1], v2[1]);
            else return Long.compare(v1[0], v2[0]);
        });

        List<long[]> merge = new ArrayList<>();
        for (long[] longs : seg) {
            if (merge.isEmpty()) {
                merge.add(longs);
            } else {
                long[] last = merge.get(merge.size() - 1);
                if (longs[0] <= last[1]) {
                    last[1] = longs[1];
                } else {
                    merge.add(longs);
                }
            }
        }

        long ans = 0;
        for (long[] s : merge) {
            ans += s[1] - s[0] + 1;
        }
        out.println(ans);
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
