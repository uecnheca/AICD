package org.example;
import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        List<List<Integer>> m = new ArrayList<>();
        m.add(List.of());
        m.add(List.of(1));
        m.add(List.of(1));
        m.add(List.of(1,2));
        m.add(List.of(1,3));
        m.add(List.of(1,3));

        System.out.println(hwoWinner(5, m));
    }

    public static String hwoWinner(int n, List<List<Integer>> m) {
        boolean[] b = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            for (int t : m.get(i)) {
                if (i-t >= 0 && !b[i-t]) {
                    b[i] = true;
                    break;
                }
            }
        }

        return b[n] ? "first" : "second";
    }
}