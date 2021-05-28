package atcoder.ABC._201;

import java.io.*;
import java.util.*;

import library.basic.*;
import library.algorithm.Mint;

public class Main {
    private static final boolean N_CASE = false;
    private static Mint Mt = new Mint();
 
    public static class Node {
        int v;
        long w;
        public Node(int v, long w) {
            this.v = v;
            this.w = w;
        } 
    }
 
    private void solve() {
        int N = sc.nextInt();
        List<List<Node>> g = cu.createGraph(N);
        for (int i = 1; i < N; ++i) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            long w = sc.nextLong();
            g.get(u).add(new Node(v, w));
            g.get(v).add(new Node(u, w));
        }
 
        Deque<Integer> q = new ArrayDeque<>();
        long[] dist = new long[N]; Arrays.fill(dist, -1);
        dist[0] = 0; q.add(0);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (Node node : g.get(u)) {
                int v = node.v;
                long w = node.w;

                if (dist[v] == -1) {
                    dist[v] = dist[u] ^ w;
                    q.add(v);
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < 60; ++i) {
            int[] cnt = new int[2];
            for (int u = 0; u < N; ++u) {
                ++cnt[(int)(dist[u]>>i&1)];
            }
            long bitVal = Mt.get(1L<<i);
            ans += Mt.mul(bitVal, Mt.mul(cnt[0], cnt[1]));
            ans = Mt.get(ans);
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
        cu = new CommonUtils();
        new Main().run();
        out.close();
    }
}
