package codejam._2020.Round1C.B;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import library.basic.*;

public class Solution {
    private static final boolean N_CASE = true;
    private static final int Q = 10000;

    private void solve() {
        int U = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int k = 0; k < Q; ++k) {
            long qi = sc.nextLong();
            String N = sc.next();
            for (char c : N.toCharArray()) {
                set.add(c - 'A');
            }

            if (N.length() == U) {
                int x = N.charAt(0) - 'A';
                count.put(x, count.getOrDefault(x, 0) + 1);
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            list.add(Arrays.asList(e.getKey(), e.getValue()));
        }
        list.sort(Comparator.comparing(v->v.get(1)));
        StringBuilder ans = new StringBuilder();
        for (int x : set) {
            if (!count.containsKey(x)) ans.append((char)(x + 'A'));
        }

        for (int i = list.size() -1; i>= 0; --i) {
            ans.append((char)(list.get(i).get(0)+'A'));
        }
        out.println(ans.toString());
    }

    private void run() {
        int T = N_CASE ? sc.nextInt() : 1;
        for (int t = 0; t < T; ++t) {
            out.print(String.format("Case #%d: ", t + 1));
            solve();
        }
    }

    private static MyWriter out;
    private static MyScanner sc;
    private static CommonUtils cu;

    public static void main(String[] args) {
        out = new MyWriter(new BufferedOutputStream(System.out));
        sc = new MyScanner();
        new Solution().run();
        out.close();
    }
}