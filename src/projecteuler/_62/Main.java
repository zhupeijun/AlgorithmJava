package projecteuler._62;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<String, List<Long>> map = new HashMap<>();
        for (int i = 1; i < 20000; ++i) {
            long v = (long)i*i*i;
            String to = Arrays.stream(String.valueOf(v).split(""))
                    .sorted()
                    .collect(Collectors.joining());

            List<Long> list = map.computeIfAbsent(to, k -> new ArrayList<>());
            list.add(v);
            if (list.size() >= 5) {
                System.out.println(list);
            }
        }
    }
}
