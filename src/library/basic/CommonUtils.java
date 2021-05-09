package library.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonUtils {
    public <T> List<List<T>> createGraph(int n) {
        List<List<T>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    public void fill(int[][] a, int value) {
        for (int[] row : a) {
            fill(row, value);
        }
    }

    public void fill(int[] a, int value) {
        Arrays.fill(a, value);
    }

    public void swap(List<Integer> a, int i, int j) {
        int t = a.get(i); a.set(i, a.get(j)); a.set(j, t);
    }

    public void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
