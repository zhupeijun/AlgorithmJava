package library.algorithm;

public class BIT {
    int[] dat;
    int n;

    public BIT(int n) {
        this.n = n;
        this.dat = new int[n + 1];
    }

    public int sum(int i) {
        int s = 0;
        while (i > 0) {
            s += dat[i];
            i -= (i & -i);
        }
        return s;
    }

    // i start from 1
    public void add(int i, int x) {
        while (i <= n) {
            dat[i] += x;
            i += (i & -i);
        }
    }
}