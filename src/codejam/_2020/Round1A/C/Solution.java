package codejam._2020.Round1A.C;

import java.io.*;
import java.util.*;

import library.basic.*;

public class Solution {
    private static final boolean N_CASE = true;
    private static final int[][] D4 = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static class Node {
        int val;
        Node[] nxt;

        public Node(int val) {
            this.val = val;
            this.nxt = new Node[D4.length];
        }

        public boolean needRemove() {
            int sum = 0, cnt = 0;
            for (int i = 0; i < nxt.length; ++i) {
                if (nxt[i] != null) {
                    sum += nxt[i].val;
                    ++cnt;
                }
            }
            return cnt * val < sum;
        }
    }

    private void solve() {
        int R = sc.nextInt();
        int C = sc.nextInt();

        Node[][] nodes = new Node[R][C];

        long tot = 0;
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                int val = sc.nextInt();
                nodes[i][j] = new Node(val);
                tot += val;
            }
        }

        // build a double linked list with neighbor
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                Node x = nodes[i][j];
                for (int k = 0; k < D4.length; ++k) {
                    int[] d = D4[k];
                    int ni = i + d[0], nj = j + d[1];
                    if (isValid(ni, nj, R, C)) {
                        Node y = nodes[ni][nj];
                        x.nxt[k] = y;
                        y.nxt[(k+2)%4] = x;
                    }
                }
            }
        }

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                list.add(nodes[i][j]);
            }
        }

        long ans = 0;
        while (true) {
            ans += tot;

            // check nodes need to be removed
            Set<Node> rm = new HashSet<>();
            for (Node x : list) {
                if (x.needRemove()) {
                    rm.add(x);
                    tot -= x.val;
                }
            }

            if (rm.isEmpty()) {
                break;
            }

            // collect updated cells
            list.clear();
            Set<Node> set = new HashSet<>();
            for (Node x : rm) {
                for (int i = 0; i < x.nxt.length; ++i) {
                    if (x.nxt[i] != null && !rm.contains(x.nxt[i])) {
                        set.add(x.nxt[i]);
                    }
                }
            }

            // update neighbor
            for (Node x : rm) {
                for (int i = 0; i < x.nxt.length; ++i) {
                    int ri = (i+2)%4;
                    if (x.nxt[i] != null) {
                        x.nxt[i].nxt[ri] = x.nxt[ri];
                    }
                }
            }

            list.addAll(set);
        }

        out.println(ans);
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