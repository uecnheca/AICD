package org.example;

public class Log {
    public static double log(int N) {
        double result = 0.0;
        for (int i = 2; i <= N; i++) {
            result += Math.log(i);
        }
        return result;
    }

    public static void main(String[] args) {
        double res = log(5);
        System.out.println(res);
    }
}