package atcoder.ABC._201;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private static class Mat implements Comparable<Mat> {
        String name;
        int height;

        public Mat(String name, int height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(Mat o) {
            return o.height - height;
        }
    }

    private void solve() {
        int N = sc.nextInt();
        List<Mat> a = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            String name = sc.next();
            int height = sc.nextInt();
            a.add(new Mat(name, height));
        }

        Collections.sort(a);

        out.println(a.get(1).name);
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
