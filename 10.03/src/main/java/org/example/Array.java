package org.example;

import java.util.*;

public class Array {
    public static void main(String[] args) {
        int[] nums1 = {2, 4, 4, 1};
        int[] nums2 = {2, 2, 4, 5};

        int[] result = func(nums1, nums2);
        System.out.println(Arrays.toString(result)); // [2, 4]
    }

    public static int[] func(int[] nums1, int[] nums2) {
        // 1. Создаем частотные карты для обоих массивов
        Map<Integer, Integer> arr1 = createFrequencyMap(nums1);
        Map<Integer, Integer> arr2 = createFrequencyMap(nums2);

        Set<Integer> keys = new HashSet<>(arr1.keySet());
        keys.retainAll(arr2.keySet());

        List<Integer> result = new ArrayList<>();
        for (int key : keys) {
            int count = Math.min(arr1.get(key), arr2.get(key));
            for (int i = 0; i < count; i++) {
                result.add(key);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private static Map<Integer, Integer> createFrequencyMap(int[] nums) {
        Map<Integer, Integer> Map = new HashMap<>();
        for (int num : nums) {
            Map.put(num, Map.getOrDefault(num, 0) + 1);
        }
        return Map;
    }
}