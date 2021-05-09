package atcoder.ABC._198.D;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

import library.algorithm.Permutation;
import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;
    private int[] map;
    private int label;
    private String s1;
    private String s2;
    private String s3;


    private long tr(String s, List<Integer> val) {
        long ans = 0;
        for (char c : s.toCharArray()) {
            ans = ans * 10 + val.get(map[id(c)]);
        }
        return ans;
    }

    private boolean ck(String s, List<Integer> val) {
        return val.get(map[id(s.charAt(0))]) != 0;
    }

    private int id(char c) { return c - 'a'; }

    private void add(char c) {
        int k = id(c);
        if (map[k] == -1) {
            map[k] = label++;
        }
    }

    private void solve() {
        s1 = sc.next();
        s2 = sc.next();
        s3 = sc.next();

        label = 0;
        map = new int[26]; Arrays.fill(map, -1);
        for (char c : s1.toCharArray()) add(c);
        for (char c : s2.toCharArray()) add(c);
        for (char c : s3.toCharArray()) add(c);

        if (label > 10) {
            out.println("UNSOLVABLE");
            return;
        }

        final boolean[] fin = new boolean[1];
        new Permutation(10, p-> {
            if (ck(s1, p) && ck(s2, p) && ck(s3, p)) {
                long n1 = tr(s1, p);
                long n2 = tr(s2, p);
                long n3 = tr(s3, p);

                if (n1 + n2 == n3) {
                    out.println(n1);
                    out.println(n2);
                    out.println(n3);
                    fin[0] = true;
                    return true;
                }
            }
            return false;
        });

        if (!fin[0]) {
            out.println("UNSOLVABLE");
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