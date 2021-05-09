package codeforces._703.D;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private static class Median {
        private PriorityQueue<Integer> left;
        private PriorityQueue<Integer> right;

        public Median() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int x) {
            left.add(x);
            if (left.size() - right.size() > 1) {
                right.add(left.poll());
            }
        }

        public int get() {
            return left.isEmpty() ? -1 : left.peek();
        }
    }

    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = sc.nextIntArray(n);

        Median m = new Median();
        for (int i = 0; i < n; ++i) {
            m.add(a[i]);

        }
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