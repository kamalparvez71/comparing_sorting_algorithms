import java.util.*;

public class CompareSortingApplication {

    // Check if an array is sorted
    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        final int n = 1000;
        int[] original = new int[n];
        Random rand = new Random();

        // Generate random array
        for (int i = 0; i < n; i++) {
            original[i] = rand.nextInt(10000);
        }

        // Bubble Sort
        int[] a1 = Arrays.copyOf(original, n);
        long t0 = System.nanoTime();
        BubbleSort.sort(a1);
        long t1 = System.nanoTime();
        double bubbleSec = (t1 - t0) / 1e9;
        boolean ok1 = isSorted(a1);

        // Selection Sort
        int[] a2 = Arrays.copyOf(original, n);
        t0 = System.nanoTime();
        SelectionSort.sort(a2);
        t1 = System.nanoTime();
        double selectionSec = (t1 - t0) / 1e9;
        boolean ok2 = isSorted(a2);

        // Insertion Sort
        int[] a3 = Arrays.copyOf(original, n);
        t0 = System.nanoTime();
        InsertionSort.sort(a3);
        t1 = System.nanoTime();
        double insertionSec = (t1 - t0) / 1e9;
        boolean ok3 = isSorted(a3);

        // Merge Sort
        int[] a4 = Arrays.copyOf(original, n);
        t0 = System.nanoTime();
        MergeSort.sort(a4);
        t1 = System.nanoTime();
        double mergeSec = (t1 - t0) / 1e9;
        boolean ok4 = isSorted(a4);

        // Print results
        System.out.printf("Bubble Sort Time: %.3f sec%n", bubbleSec);
        System.out.printf("Selection Sort Time: %.3f sec%n", selectionSec);
        System.out.printf("Insertion Sort Time: %.3f sec%n", insertionSec);
        System.out.printf("Merge Sort Time: %.3f sec%n", mergeSec);

        boolean allCorrect = ok1 && ok2 && ok3 && ok4;
        System.out.println("All sorts correct? " + (allCorrect ? "True" : "False"));

        List<String> words = Arrays.asList("apple", "tea", "pie", "banana", "kiwi");
        StringSorter stringSorter = new StringSorter();
        List<String> sortedWords = stringSorter.sortStrings(words);

        String formatted = sortedWords.stream()
                .map(s -> "\"" + s + "\"")
                .toList()
                .toString();

        System.out.println("Output: " + formatted);
    }
}
