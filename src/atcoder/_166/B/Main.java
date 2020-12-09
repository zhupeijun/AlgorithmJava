package atcoder._166.B;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private void run() {
        int N = sc.nextInt();
        int K = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < K; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                set.add(sc.nextInt());
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (!set.contains(i)) {
                ++ans;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
