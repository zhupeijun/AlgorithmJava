package library.algorithm;

import java.util.*;
import java.util.function.Function;

public class Permutation {
    private final Function<List<Integer>, Boolean> consumer;
    private final List<Integer> p;
    private final int n;
    private final boolean[] used;


    public Permutation(int n, Function<List<Integer>, Boolean> consumer) {
        this.n = n;
        this.consumer = consumer;
        this.p = new ArrayList<>();
        this.used = new boolean[n];

        dfs();
    }

    public boolean dfs() {
        if (p.size() == n) {
            // stop when return true
            return consumer.apply(p);
        }

        for (int j = 0; j < n; ++j) {
            if (!used[j]) {
                used[j] = true;
                p.add(j);
                if (dfs()) return true;
                p.remove(p.size()-1);
                used[j] = false;
            }
        }
        return false;
    }
}