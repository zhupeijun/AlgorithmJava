package library.algorithm;

public class Seg {
    long[] data, datb;
    int n;

    public Seg(int m) {
        n = 1;
        while (n < m) n *= 2;
        data = new long[n * 2];
        datb = new long[n * 2];
    }

    public void add(int a, int b, long x) {
        add(a, b, x, 0, 0, n);
    }

    public long sum(int a, int b) {

        return sum(a, b, 0, 0, n);
    }

    public void add(int a, int b, long x, int k, int l, int r) {
        if (a <= l && r <= b) {
            data[k] += x;
        } else if (l < b && a < r) {
            datb[k] += (Math.min(b, r) - Math.max(a, l)) * x;
            add(a, b, x, k * 2 + 1, l, (l+r)/2);
            add(a, b, x, k * 2 + 2, (l+r)/2, r);
        }
    }

    public long sum(int a, int b, int k, int l, int r) {
        if (b <= l || r <= a) {
            return 0;
        } else if (a <= l && r <= b) {
            return data[k] * (r - l) + datb[k];
        } else {
            long res = (Math.min(b, r) - Math.max(a, l)) * data[k];
            res += sum(a, b, k * 2 + 1, l, (l+r)/2);
            res += sum(a, b, k * 2 + 2, (l+r)/2, r);
            return res;
        }
    }
}