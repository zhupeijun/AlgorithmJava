package atcoder.ABC.jsc2021;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private boolean isPal(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            ++l; --r;
        }
        return r <= l;
    }

    private void dfs(int l, int r, int rev, int level,
                    String s,  
                    List<String> a,
                    List<List<Character>> b) {
        if (level == 0) {
            if (rev == 0) a.add(s.substring(l, r+1));
            else a.add(reverse(s.substring(l, r+1)));
            return;
        }

        int N = r - l + 1;
        int mid = (l+r)/2;
        if (N % 2 == 0) {
            dfs(l, mid, 0, level-1, s, a, b);
            dfs(mid+1, r, 1, level-1, s, a, b);
        } else {
            dfs(l, mid-1, 0, level-1, s, a, b);
            dfs(mid+1, r, 1, level-1, s, a, b);
            b.get(level).add(s.charAt(mid));
        }
    }

    private void solve() {
        int K = sc.nextInt();
        String s = sc.next();
        int N = s.length();

        int len = N, x = K;
        while (x > 0 && len > 0) {
            if (len % 2 == 0) {
                len = len / 2;
            } else {
                len = (len-1)/2;
            }
            --x;
        }

//        System.out.println(x +" " + len);

        if (x > 0 || len == 1) {
            out.println("impossible");
            return;
        }

        List<String> a = new ArrayList<>();
        List<List<Character>> b = cu.createGraph(K+1);

        dfs(0,N-1, 0, K, s, a, b);

        final int cn = 26;
        int[][] cnt = new int[len][cn];
        for (int i = 0; i < a.size(); ++i) {
            for (int j = 0; j < len; ++j) {
                int c = a.get(i).charAt(j) - 'a';
                ++cnt[j][c];
            }
        }

        StringBuilder tmp = new StringBuilder();
        List<List<Integer>> d = cu.createGraph(len);
        for (int i = 0; i < len; ++i) {
            int min = 0;
            int c = -1;
            for (int j = 0; j < cn; ++j) {
                int need = a.size() - cnt[i][j];
                if (c == -1 || min > need) {
                    min = need;
                    c = j;
                }
                d.get(i).add(need);
            }
            tmp.append((char)('a'+c));
        }

        int ans = 0;
        for (List<Character> list : b) {
            int[] lc = new int[26];
            int ln = list.size();
            for (char c : list) {
                ++lc[c - 'a'];
            }

            int min = 0, c = -1;
            for (int i = 0; i < 26; ++i) {
                int need = ln - lc[i];
                if (c == -1 || min > need) {
                    c = i; 
                    min = need;
                }
            }

            ans += min;
        }

        if (len == 0) {
            out.println(ans);
            return;
        }

        for (List<Integer> list : d) {
            Collections.sort(list);
        }

        int sum = 0;
        for (List<Integer> list : d) {
            sum += list.get(0);
        }

        // System.out.println(tmp);
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(d);

        if (!isPal(tmp.toString())) {
            out.println(ans + sum);
            return;
        }

        int minDiff = Integer.MAX_VALUE;
        int dn = d.size();
        for (int i = 0; i < dn; ++i) {
            // 2, abaabaadagdg
           if (dn % 2 == 1 && i == dn / 2) continue;
            List<Integer> list = d.get(i);
            minDiff = Math.min(minDiff, list.get(1) - list.get(0));
        }

        out.println(ans + sum + minDiff);
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
