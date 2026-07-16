package main.Coding.Algorithms.Classic.Sort.QuickSort;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        int [] sample = new int [] {3,2,1,5,6,7,8,9,23,4,3};
        test.quickSort(sample);
        for (int i = 0; i < sample.length; i++) {
            System.out.print(sample[i] + " ");
        }
    }


    public void quickSort(int [] arr) {
        if (arr == null || arr.length <= 1) return;
        helper(arr, 0, arr.length - 1);
    }

    public void  helper (int [] arr, int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);
            helper(arr, l, pivot - 1);
            helper(arr,pivot + 1, r);
        }
    }
    public int partition (int [] arr, int l, int r) {
        int pivot = arr[r];
        int index = l - 1;
        for (int i = l; i < r; i++) {
            if (arr[i] <= pivot) {
                index++;
                swap(arr, i,index);
            }
        }
        swap(arr, index + 1, r);
        return pivot;
    }

    public void swap (int [] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
