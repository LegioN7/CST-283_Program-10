package org.example.program10;

public class SortResult {
    private int[] sortedArray;
    private int comparisons;
    private int swaps;

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
