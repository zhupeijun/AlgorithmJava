package codechef.MARCH21B.PAPARAZI;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = true;

    private long cross(long ax, long ay, long bx, long by, long cx, long cy) {
        return (bx - ax) * (cy - ay) - (cx - ax) * (by - ay);
    }

    private void solve() {
        int n = sc.nextInt();
        int[] h = sc.nextIntArray(n);

        if (n == 2) {
            out.println(1);
            return;
        }

        List<Integer> stack = new ArrayList<>();
        stack.add(0);
        stack.add(1);

        int ans = 0;
        for (int i = 2; i <n; ++i) {
            while (stack.size() >= 2) {

                int ax = stack.get(stack.size() - 2);
                int bx = stack.get(stack.size() - 1);
                int ay = h[ax];
                int by = h[bx];
                int cx = i;
                int cy = h[i];

                long ret = cross(ax, ay, bx, by, cx, cy);
                if (ret >= 0) {
                    stack.remove(stack.size() - 1);
                } else {
                    break;
                }
            }
            int dist = i - stack.get(stack.size() - 1);
            ans = Math.max(ans, dist);
            stack.add(i);
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
        new Main().run();
        out.close();
    }
}