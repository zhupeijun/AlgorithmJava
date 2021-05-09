package library.algorithm;

public class UnionSet {
    int[] count;
    int[] rank;
    int[] parent;

    public UnionSet(int n) {
        count = new int[n];
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            count[i] = 1;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (rank[x] > rank[y]) {
                parent[y] = x;
                count[x] += count[y];
            } else {
                parent[x] = y;
                count[y] += count[x];
                if (rank[x] == rank[y]) {
                    ++rank[x];
                }
            }
        }
    }
}