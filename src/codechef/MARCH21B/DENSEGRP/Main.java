package codechef.MARCH21B.DENSEGRP;

import library.basic.*;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = true;
    private static final int MAX = 1000000;

    private static class R implements Comparable<R> {
        int x, y;

        public R(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(R o) {
            if (x == o.x) return y - o.y;
            return x - o.x;
        }

        private boolean intersect(R o) {
            return !(x > o.y || y < o.x);
        }
    }

    private static class QNode {
        int d;
        R r;

        public QNode(int d, R r) {
            this.d = d;
            this.r = r;
        }
    }

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        int[] A = new int[M];
        int[] B = new int[M];
        int[] C = new int[M];
        int[] D = new int[M];


        Map<Integer, Integer> idMap = new HashMap<>();
        TreeMap<R, List<R>> tm = new TreeMap<>();
        for (int i = 0; i < M; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
            C[i] = sc.nextInt();
            D[i] = sc.nextInt();

            idMap.putIfAbsent(A[i], idMap.size());
            idMap.putIfAbsent(B[i], idMap.size());
            idMap.putIfAbsent(C[i], idMap.size());
            idMap.putIfAbsent(D[i], idMap.size());

            R u = new R(A[i], B[i]);
            R v = new R(C[i], D[i]);

            List<R> list = tm.computeIfAbsent(u, key -> new ArrayList<>());
            list.add(v);
        }

        Deque<QNode> q = new ArrayDeque<>();
        q.add(new QNode(0, new R(X, X)));
        int ans = -1;
        while (!q.isEmpty()) {
            QNode node = q.poll();
            R u = node.r;
            if (u.x <= Y && u.y >= Y) {
                ans = node.d;
                break;
            }

            R preKey = tm.lowerKey(new R(u.y+1, u.y+1));
            List<R> rm = new ArrayList<>();
            while (preKey != null) {
                if (preKey.intersect(u)) {
                    List<R> child = tm.get(preKey);
                    for (R v : child) {
                        q.add(new QNode(node.d+1, v));
                    }
                    rm.add(preKey);
                    preKey = tm.lowerKey(preKey);
                } else {
                    break;
                }
            }

            for (R v : rm) {
                tm.remove(v);
            }
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