package org.example;

public class Task1_2 {
    public static String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        char[] chars = s.toCharArray();
        int n = chars.length;

        reverse(chars, 0, n - 1);

        int start = 0;
        while (start < n) {
            while (start < n && chars[start] == ' ') {
                start++;
            }
            if (start >= n) {
                break;
            }
            int end = start;
            while (end < n && chars[end] != ' ') {
                end++;
            }
            reverse(chars, start, end - 1);

            start = end;
        }

        return noSpaces(chars);
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    private static String noSpaces(char[] chars) {
        int left = 0;
        int right = 0;
        int n = chars.length;

        while (right < n) {
            while (right < n && chars[right] == ' ') {
                right++;
            }
            if (right >= n) {
                break;
            }
            if (left != 0) {
                chars[left++] = ' ';
            }
            while (right < n && chars[right] != ' ') {
                chars[left++] = chars[right++];
            }
        }

        return new String(chars, 0, left);
    }
    public static void main(String[] args) {
        String s1 = "the sky is blue";
        System.out.println(reverseWords(s1));

    }
}