package atcoder.ABC._166.D;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private long pow(long x) {
        long r = 1;
        for (int i = 0; i < 5; ++i) {
            r *= x;
        }
        return r;
    }

    private void run() {
        long t = sc.nextLong();
        for (long x = 0; x <= 1000; ++x) {
            for (long y = -1000; y <= 1000; ++y) {
                long v = pow(x) - pow(y);
                if (v == t) {
                    System.out.println(String.format("%d %d", x, y));
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
