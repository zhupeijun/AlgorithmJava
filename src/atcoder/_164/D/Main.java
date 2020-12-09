package atcoder._164.D;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private void solve() {
        String s = sc.next();
        int n = s.length();
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int total = 0;
        final int M = 2019;
        int pr = 0;
        int br = 1;
        for (int i = n - 1; i >= 0; --i) {
            int d = s.charAt(i) - '0';
            int r = (((br * d) % M) + pr) % M;

            total += count.getOrDefault(r, 0);
            count.put(r, count.getOrDefault(r, 0) + 1);

            pr = r;
            br = (br * 10) % M;
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
