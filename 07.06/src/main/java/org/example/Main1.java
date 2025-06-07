package org.example;

import java.util.*;

public class Main1 {
    public static int[] find(int[] arr, int t) {
        int n = arr.length;
        int closestSum = Integer.MAX_VALUE;
        int[] result = new int[3];
        int minDiff = Integer.MAX_VALUE;


        Map<Integer, int[]> duet = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (Map.Entry<Integer, int[]> entry : duet.entrySet()) {
                int pairSum = entry.getKey();
                int currentSum = pairSum + arr[i];
                int diff = Math.abs(currentSum - t);
                if (diff < minDiff) {
                    minDiff = diff;
                    result[0] = arr[i];
                    result[1] = entry.getValue()[0];
                    result[2] = entry.getValue()[1];
                }
            }


            for (int j = 0; j < i; j++) {
                int sum = arr[i] + arr[j];
                duet.put(sum, new int[]{arr[i], arr[j]});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 3, 2, 1, 7, 5};
        int t = 9;
        int[] res = find(arr, t);
        System.out.println(res[0] + " + " + res[1] + " + " + res[2]);
    }
}