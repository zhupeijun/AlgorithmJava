package atcoder.ABC._166.F;
import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private List<String> result;

    private void exec(int[] x, int i, int j) {
        result.add(String.valueOf((char)(i + 'A')));
        ++x[i];
        --x[j];
    }

    private void run() {
        int N = sc.nextInt();
        int[] x = new int[3];
        x[0] = sc.nextInt();
        x[1] = sc.nextInt();
        x[2] = sc.nextInt();

        boolean ans = true;
        result = new ArrayList<>();
        List<String> op = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            op.add(sc.next());
        }

        for (int i = 0; i < N; i++) {
            String s = op.get(i);
            if (!ans) {
                continue;
            }

            if (s.equals("AB")) {
                if (x[0] > x[1]) {
                    exec(x, 1, 0);
                } else if (x[0] < x[1]) {
                    exec(x, 0, 1);
                } else {
                    if (x[0] == 1) {
                        if (i + 1 < N) {
                            String nx = op.get(i + 1);
                            if (nx.equals("AC")) {
                                exec(x, 0, 1);
                            } else {
                                exec(x, 1, 0);
                            }
                        } else {
                            exec(x, 0, 1);
                        }
                    } else {
                        exec(x, 0, 1);
                    }
                }
            } else if (s.equals("BC")) {
                if (x[1] > x[2]) {
                    exec(x, 2, 1);
                } else if (x[1] < x[2]){
                    exec(x, 1, 2);
                } else {
                    if (x[1] == 1) {
                        if (i + 1 < N) {
                            String nx = op.get(i + 1);
                            if (nx.equals("AC")) {
                                exec(x, 2, 1);
                            } else {
                                exec(x, 1, 2);
                            }
                        } else {
                            exec(x, 1, 2);
                        }
                    } else {
                        exec(x, 2, 1);
                    }
                }
            } else {
                if (x[0] > x[2]) {
                    exec(x, 2, 0);
                } else if (x[0] < x[2]){
                    exec(x, 0, 2);
                } else {
                    if (x[0] == 1) {
                        if (i + 1 < N) {
                            String nx = op.get(i + 1);
                            if (nx.equals("AB")) {
                                exec(x, 0, 2);
                            } else {
                                exec(x, 2, 0);
                            }
                        } else {
                            exec(x, 0, 2);
                        }
                    } else {
                        exec(x, 0, 2);
                    }
                }
            }

            if (x[0] < 0 || x[1] < 0 || x[2] < 0) {
                ans = false;
            }
        }

        if (ans) {
            System.out.println("Yes");
            result.forEach(System.out::println);
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
