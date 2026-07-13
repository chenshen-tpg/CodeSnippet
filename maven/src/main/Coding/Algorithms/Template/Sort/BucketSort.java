package main.Coding.Algorithms.Template.Sort;

import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Arrays.sort(arr);
        bucketSort(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(int[] arr, int bucketCount) {
        if (arr.length == 0) return;
        int min = arr[0], max = arr[0];
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int bucketSize = Math.max(1, (max - min + 1) / bucketCount);
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int num : arr) {
            int idx = (num - min) / bucketSize;
            idx = Math.min(idx, bucketCount - 1);
            buckets.get(idx).add(num);
        }

        int k = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                arr[k++] = num;
            }
        }
    }
    // Better version to handle edge case and extra large
    public static void RefinedBucketSort(int[] arr, int bucketCount) {
        if (arr == null || arr.length <= 1 || bucketCount <= 0) return;
        int min = arr[0], max = arr[0];
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // Edge case: All elements are identical
        if (min == max) return;
        // Initialize buckets
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        // Distribute elements evenly across buckets
        long range = (long) max - min; // long prevents integer overflow if max/min are near limits
        for (int num : arr) {
            // Safe mathematical scaling to bucket index
            int idx = (int) (((long) num - min) * (bucketCount - 1) / range);
            buckets.get(idx).add(num);
        }
        // Sort buckets and merge back into arr
        int k = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                arr[k++] = num;
            }
        }
    }
}