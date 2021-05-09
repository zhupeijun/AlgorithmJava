package atcoder.ABC._197.D;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private void solve() {
        int N = sc.nextInt();
        double x1 = sc.nextInt();
        double y1 = sc.nextInt();
        double x2 = sc.nextInt();
        double y2 = sc.nextInt();

        double cx = (x1+x2)/2;
        double cy = (y1+y2)/2;

        double d = Math.PI * 2 / N;
        x1 -= cx;
        y1 -= cy;

        double x3 = x1 * Math.cos(d) - y1 * Math.sin(d);
        double y3 = y1 * Math.cos(d) + x1 * Math.sin(d);

        x3 += cx;
        y3 += cy;

        out.println(x3 + " " + y3);
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