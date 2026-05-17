package main.Concept.JavaQuestion.Heap;

public class MinHeap {
    private int[] heap;
    private int size;

    public MinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 1, 2};
        MinHeap heap = new MinHeap(arr.length);
        heap.buildHeap(arr);
        System.out.println(heap.extractMin()); // Output: 1
        heap.insert(0);
        System.out.println(heap.extractMin()); // Output: 0
    }

    // Insert a new value into the heap
    public void insert(int val) {
        if (size == heap.length) throw new IllegalStateException("Heap full");
        heap[size] = val;
        siftUp(size);
        size++;
    }

    // Remove and return the minimum element
    public int extractMin() {
        if (size == 0) throw new IllegalStateException("Heap empty");
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return min;
    }

    // Heapify an array (build heap in O(n))
    public void buildHeap(int[] arr) {
        heap = arr;
        size = arr.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap[i] < heap[parent]) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    private void siftDown(int i) {
        while (2 * i + 1 < size) {
            int left = 2 * i + 1, right = 2 * i + 2, smallest = i;
            if (heap[left] < heap[smallest]) smallest = left;
            if (right < size && heap[right] < heap[smallest]) smallest = right;
            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
