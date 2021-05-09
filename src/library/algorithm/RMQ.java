package library.algorithm;

public class RMQ {
    int n;
    long[] dat;

    public RMQ(int n_) {
        n = 1;
        while (n < n_) n *= 2;
        dat = new long[2 * n - 1];
        for (int i = 0; i < 2 * n - 1; ++i) dat[i] = 0;
    }

    public void replace(int k, int a) {
        update(k, a, true);
    }

    public void update(int k, long a) {
        update(k, a, false);
    }

    private void update(int k, long a, boolean replace) {
        k += n - 1;
        // use this if need keep max value
        // data[k] = Math.max(dat[k], a);
        dat[k] = replace ? a : Math.max(dat[k], a);
        while (k > 0) {
            k = (k - 1) / 2;
            dat[k] = Math.max(dat[k * 2 + 1], dat[k * 2 + 2]);
        }
    }

    public long query(int a, int b, int k, int l, int r) {
        if (r <= a || b <= l) return 0;
        if (a <= l && r <= b) return dat[k];
        else {
            int mid = (l + r) / 2;
            long vl = query(a, b, k * 2 + 1, l, mid);
            long vr = query(a, b, k * 2 + 2, mid, r);
            return Math.max(vl, vr);
        }
    }

    public long query(int a, int b) {
        return query(a, b, 0, 0, n);
    }
}
