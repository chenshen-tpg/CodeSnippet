package main.Coding.Algorithms.Classic.Sort.QuickSort;

import java.util.concurrent.ThreadLocalRandom;

public class AIRefinedVersion {
    public static void main(String[] args) {

    }
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSort3Way(arr, 0, arr.length - 1);
    }

    private static void quickSort3Way(int[] arr, int low, int high) {
        if (low >= high) return;

        // Optional tiny-range optimization
        if (high - low <= 16) {
            insertionSort(arr, low, high);
            return;
        }

        // Randomized pivot to avoid pathological input patterns
        int pivotIndex = ThreadLocalRandom.current().nextInt(low, high + 1);
        int pivot = arr[pivotIndex];

        // 3-way partition: [low..lt-1] < pivot, [lt..gt] == pivot, [gt+1..high] > pivot
        int lt = low, i = low, gt = high;
        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }
        quickSort3Way(arr, low, lt - 1);
        quickSort3Way(arr, gt + 1, high);
    }

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
