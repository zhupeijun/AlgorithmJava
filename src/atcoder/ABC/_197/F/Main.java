package atcoder.ABC._197.F;

import java.io.*;
import java.util.*;
import java.util.function.*;

import library.basic.*;

public class Main {
    private static final boolean N_CASE = false;

    private static int en(int x, int y, int N) {
        return x * N + y;
    }

    private void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[M];
        int[] B = new int[M];
        String[] C = new String[M];

        for (int i = 0; i < M; ++i) {
            A[i] = sc.nextInt() - 1;
            B[i] = sc.nextInt() - 1;
            C[i] = sc.next();
        }

        int tot = N*N;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < tot; ++i) g.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (C[i].equals(C[j])) {
                    g.get(en(A[i],A[j],N)).add(en(B[i],B[j],N));
                    g.get(en(B[i],B[j],N)).add(en(A[i],A[j],N));
                    g.get(en(B[i],A[j],N)).add(en(A[i],B[j],N));
                    g.get(en(A[i],B[j],N)).add(en(B[i],A[j],N));
                }
            }
        }

        int[] dist = new int[tot];
        Arrays.fill(dist, -1);
        Deque<Integer> q = new ArrayDeque<>();
        int root = en(0,N-1, N);
        int end = en(N-1, 0, N);
        q.add(root);
        dist[root] = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            List<Integer> child = g.get(u);
            if (child == null) continue;
            int d = dist[u];
            if (u == end) {
                break;
            }
            for (int v : child) {
                if (dist[v] == -1) {
                    dist[v] = d + 1;
                    q.add(v);
                }
            }
        }
        out.println(dist[end]);
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