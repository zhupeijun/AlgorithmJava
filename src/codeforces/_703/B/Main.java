package codeforces._703.B;

import library.basic.*;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;

    private void solve() {
        int n = sc.nextInt();

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x.add(sc.nextInt());
            y.add(sc.nextInt());
        }

        Collections.sort(x);
        Collections.sort(y);

        int nx = x.size();
        int ny = y.size();
        long dx = x.get(nx / 2) - x.get((nx - 1) / 2) + 1;
        long dy = y.get(ny / 2) - y.get((ny - 1) / 2) + 1;

        out.println(dx * dy);
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