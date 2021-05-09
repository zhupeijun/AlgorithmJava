package library.algorithm;

import java.util.TreeMap;

public class MultiSet<T extends Comparable<T>> {
    private final TreeMap<T, Integer> map;

    public MultiSet() {
        map = new TreeMap<>();
    }

    public void add(T x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    public void remove(T x) {
        map.put(x, map.getOrDefault(x, 0) - 1);
        if (map.get(x) <= 0) {
            map.remove(x);
        }
    }

    public T min() {
        return map.firstKey();
    }

    public T max() {
        return map.lastKey();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }
}
