package codeforces._637.A;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private void solve() {
        int T = sc.nextInt();
        for (int t = 0; t < T; ++t) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            int sd = a - b;
            int su = a + b;
            int md = c - d;
            int mu = c + d;

            sd *= n;
            su *= n;

            if (sd > mu || su < md) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
