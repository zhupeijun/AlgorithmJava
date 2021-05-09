package atcoder.ARC._117.D;

import library.basic.*;

import java.io.*;
import java.util.*;

public class Main {
    private static final boolean N_CASE = false;

    private int N;
    private List<List<Integer>> g;
    private int[] dist;
    private boolean[] used;
    private int[] depth;
    private int[] val;
    private int label;

    private int getDist() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0); dist[0] = 0; used[0] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.get(u)) {
                if (!used[v]) {
                    used[v] = true;
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }

        int max = -1, u = 0;
        for (int i = 0; i < N; ++i) {
            if (dist[i] > max) {
                max = dist[i]; u = i;
            }
        }
        return u;
    }

    private void getDepth(int u) {
        used[u] = true;
        for (int v : g.get(u)) {
            if (!used[v]) {
                getDepth(v);
                depth[u] = Math.max(depth[u], depth[v] + 1);
            }
        }
    }

    private void dfs(int u) {
        val[u] = label;
        used[u] = true;

        List<Integer> child = g.get(u);
        int max = -1, k = 0;
        for (int i = 0; i < child.size(); ++i) {
            int v = child.get(i);
            int d = depth[v];
            if (d > max && !used[v]) {
                max = d; k = i;
            }
        }
        cu.swap(child, child.size()-1, k);

        for (int v : g.get(u)) {
            if (!used[v]) {
                ++label;
                dfs(v);
                ++label;
            }
        }
    }

    private void solve() {
        N = sc.nextInt();
        g = cu.createGraph(N);
        for (int i = 1; i < N; ++i) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            g.get(u).add(v);
            g.get(v).add(u);
        }

        // get one node of radius
        dist = new int[N];
        used = new boolean[N];
        Arrays.fill(dist,1<<30);
        int st = getDist();

        // get path
        depth = new int[N];
        Arrays.fill(used, false);
        getDepth(st);

        val = new int[N];
        label = 1;
        Arrays.fill(used, false);
        dfs(st);

        out.printArray(val);
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