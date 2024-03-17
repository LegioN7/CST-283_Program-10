package org.example.program10;

public class SortResult {
    private final int[] sortedArray;
    private final int comparisons;
    private final int swaps;

    public SortResult(int[] sortedArray, int comparisons, int swaps) {
        this.sortedArray = sortedArray;
        this.comparisons = comparisons;
        this.swaps = swaps;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
