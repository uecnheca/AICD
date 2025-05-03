package org.example;
import java.util.Stack;

public class StackHW {
    public static void main(String[] args) {
        String sc1 = "(())()";
        System.out.println(check(sc1));
        String sc2 = "))((())()";
        System.out.println(check(sc2));
    }

    public static boolean check(String string) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            if ((string.charAt(i) == '(') || (string.charAt(i) == '{') || (string.charAt(i) == '[')) {
                stack.add(string.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if ((stack.peek() - string.charAt(i) == -1) || (stack.peek() - string.charAt(i) == -2)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}