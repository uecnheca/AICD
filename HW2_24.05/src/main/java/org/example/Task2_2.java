package org.example;
import java.util.Arrays;

public class Task2_2 {
    public static int max(int[] nums, int s) {
        if (nums == null || nums.length == 0 || s <= 0) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 0;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num <= s) {
                currentSum += num;
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {15, 5, 11, 10, 12};
        int s = 30;
        System.out.println(max(nums, s));
    }
}