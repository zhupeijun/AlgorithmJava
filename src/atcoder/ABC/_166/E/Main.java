package atcoder.ABC._166.E;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private void run() {
        int N = sc.nextInt();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        long ans = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long t = i - A[i];
            ans += map.getOrDefault(t, 0);

            long k = A[i] + i;
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
