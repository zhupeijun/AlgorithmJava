package library.algorithm;

public class BIT {
    int[] dat;
    int n;

    BIT(int n) {
        this.n = n;
        this.dat = new int[n + 1];
    }

    int sum(int i) {
        int s = 0;
        while (i > 0) {
            s += dat[i];
            i -= (i & -i);
        }
        return s;
    }

    void add(int i, int x) {
        while (i <= n) {
            dat[i] += x;
            i += (i & -i);
        }
    }
}