package poj._1733;

import java.util.*;

class UnionSet {
    public int[] parent;
    public int[] rank;
    public int[] w;

    public UnionSet(int n) {
        parent = new int[n];
        rank = new int[n];
        w = new int[n];

        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            rank[i] = 1;
            w[i] = 0;
        }
    }

    public int find(int x) {
        int px = parent[x];
        if (x != px) {
            parent[x] = find(px);
            w[x] ^= w[px];
        }
        return parent[x];
    }

    public boolean union(int x, int y, int v) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return (w[x] ^ w[y]) == v;
        }

        if (rank[px] > rank[py]) {
            parent[py] = px;
            w[py] = w[x] ^ w[y] ^ v;
        } else {
            parent[px] = py;
            w[px] = w[x] ^ w[y] ^ v;
            if (rank[px] == rank[py]) {
                ++rank[py];
            }
        }
        return true;
    }
}

class Query {
    public int u;
    public int v;
    public int w;

    public Query(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

public class Main {

    private Scanner sc = new Scanner(System.in);
    private Map<Integer, Integer> idMap;

    private int getId(int k) {
        if (!idMap.containsKey(k)) {
            idMap.put(k, idMap.size() + 1);
        }
        return idMap.get(k);
    }

    private int getValue(String s) {
        return s.equals("even") ? 0 : 1;
    }

    private void run() {
        idMap = new HashMap<>();
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Query> ql = new ArrayList<>();
        for (int i = 0; i < M; ++i) {
            int u = getId(sc.nextInt());
            int v = getId(sc.nextInt());
            int w = getValue(sc.next());

            ql.add(new Query(u, v, w));
        }

        UnionSet us = new UnionSet(idMap.size() + 1);
        int k = 0;
        while (k < M) {
            Query q = ql.get(k);
            if (!us.union(q.u - 1, q.v, q.w)) {
                break;
            }
            ++k;
        }

        System.out.println(k);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
