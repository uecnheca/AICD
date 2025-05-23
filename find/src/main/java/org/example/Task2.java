package org.example;

public class Task2 {
    public static void main(String[] args) {
        String T = "aabaa";
        String S = "aaaab";
        int result = Task(T, S);
        System.out.println(result);
    }

    public static Integer Task(String T, String S) {
        if (T.length() != S.length()) {
            return null;
        }
        if (T == S) {
            return 0;
        }
        String TT = T + T;
        int pos = TT.indexOf(S);
        if (pos != -1) {
            return T.length() - pos;
        }
        return null;
    }
}

