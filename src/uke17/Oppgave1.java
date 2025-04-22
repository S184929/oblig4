package uke17;

import java.util.*;

public class Oppgave1 {

    public static void main(String[] args) {
        int[] original = {15, 8, 1, 9, 11, 5, 10, 12};
        int k = 3;

        System.out.println("Insertion Sort (k minste):");
        int[] arr1 = Arrays.copyOf(original, original.length);
        kMinInsertionSort(arr1, k);
        System.out.println();

        System.out.println("Selection Sort (k minste):");
        int[] arr2 = Arrays.copyOf(original, original.length);
        kMinSelectionSort(arr2, k);
        System.out.println();

        System.out.println("Heap-basert (k minste):");
        int[] arr3 = Arrays.copyOf(original, original.length);
        kMinHeap(arr3, k);
        System.out.println();
    }

    // 1. Insertion Sort (modifisert)
    public static void kMinInsertionSort(int[] arr, int k) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Sett inn blant de k første hvis aktuelt
            while (j >= 0 && j >= k - 1 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            if (j < k - 1) {
                arr[j + 1] = key;
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 2. Selection Sort (modifisert)
    public static void kMinSelectionSort(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Bytt med i
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 3. Heap-basert metode
    public static void kMinHeap(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : arr) {
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
            } else if (num < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }

        // Kopier og sorter resultatet
        List<Integer> result = new ArrayList<>(maxHeap);
        Collections.sort(result);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
