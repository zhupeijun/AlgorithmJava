package projecteuler._58;

public class Main {
    private static final int[][] DIR = {{0,1},{1, 0}, {0,-1},{-1, 0}};

    private void solve() {

        int n = 3;
        int cnt = 0;
        long cur = 1;
        while (true) {
            for (int i = 0; i < 4; ++i) {
                cur += n - 1;
                boolean isPrime = true;
                for (long k = 2; k * k <= cur; ++k) {
                    if (cur % k == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    ++cnt;
                }
            }
            System.out.println(n + " " + cnt + "/" + (n * 2 - 1));
            if (cnt * 10 < n*2 - 1) {
                break;
            }

            n+=2;
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}
