package poj._2991;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final int N = 10005;

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] l = new int[n];
        int h = 0;
        for (int i = 0; i < n; ++i) {
            l[i] = sc.nextInt();
            h += l[i];
        }

        int x = 0;
        int y = h;
        for (int i = 0; i < c; ++i) {
            int k = sc.nextInt();
            int d = sc.nextInt();


        }
    }

    public static void main(String[] args) {
        Pattern p = Pattern.compile("X(_(\\d))?_end_([\\w\\d]+)_(\\d{8})");
        Matcher m = p.matcher("X_end_reporT4_20200430120012_435.tar.gz");
        if (m.find()) {
            for (int i = 0; i <= m.groupCount(); ++i) {
                System.out.println(m.group(i));
            }
        }
    }
}
