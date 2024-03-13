package org.example.program10;

// This static class defines a "home" for the following nlog2n sorting algorithms:
// - Heap sort
// - Quick sort

import java.util.Arrays;

public class SortingNlog2N {
    // ======================================================================
    //    HEAP SORT
    // ======================================================================

    // Public launch point for heap sort.
    //   1) Work is done to convert random array int heap
    //   2) Array is sorted by swapping the largest element and reheaping
    public static SortResult heapSort(int[] array) {
        int index;
        int numValues = array.length;
        int comparisons = 0;
        int swaps = 0;

        for (index = numValues / 2 - 1; index >= 0; index--) {
            comparisons++;
            reheapDown(array, index, numValues - 1);
        }

        for (index = numValues - 1; index >= 1; index--) {
            swaps++;
            swap(array, 0, index);
            reheapDown(array, 0, index - 1);
        }

        return new SortResult(array, comparisons, swaps);
    }

    // -----------------------------------------------------------------------
    // This method performs the REHEAP DOWN action to restore
    // a binary tree to a heap after a removal from the root.  This is
    // a basic, specific algorithm for integer heaps only.
    // Postcondition: Heap property is restored.
    private static void reheapDown(int[] elements, int root, int bottom) {
        int maxChild = 0;
        int rightChild;
        int leftChild;

        leftChild = root * 2 + 1;
        rightChild = root * 2 + 2;

        if (leftChild <= bottom) {
            if (leftChild == bottom)
                maxChild = leftChild;
            else if (elements[leftChild] <= elements[rightChild])
                maxChild = rightChild;
            else
                maxChild = leftChild;

            if (elements[root] < elements[maxChild]) {
                swap(elements, root, maxChild);
                reheapDown(elements, maxChild, bottom);
            }
        }
    }


    // ======================================================================
    //    QUICK SORT
    // ======================================================================

    // Public method to launch quick sort
    public static SortResult quickSort(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        int[] count = new int[2];
        doQuickSort(sortedArray, 0, sortedArray.length - 1, count);
        return new SortResult(sortedArray, count[0], count[1]);
    }

    // -----------------------------------------------------------------------
    // Recursive action of quicksort algorithm
    private static void doQuickSort(int[] array, int start, int end, int[] count) {
        int pivotPoint;

        if (start < end) {
            pivotPoint = partition(array, start, end, count);
            doQuickSort(array, start, pivotPoint - 1, count);
            doQuickSort(array, pivotPoint + 1, end, count);
        }
    }

    // -----------------------------------------------------------------------

    private static int partition(int[] array, int start, int end, int[] count) {
        int pivotValue;
        int endOfLeftList;
        int mid;

        mid = (start + end) / 2;
        swap(array, start, mid);
        pivotValue = array[start];
        endOfLeftList = start;

        for (int scan = start + 1; scan <= end; scan++) {
            count[0]++;
            if (array[scan] < pivotValue) {
                endOfLeftList++;
                swap(array, endOfLeftList, scan);
                count[1]++;
            }
        }

        swap(array, start, endOfLeftList);
        return endOfLeftList;
    }


    // ======================================================================
    // A swap function for the 'elements' array.
    private static void swap(int[] elements, int fromIndex, int toIndex) {
        int temp = elements[fromIndex];
        elements[fromIndex] = elements[toIndex];
        elements[toIndex] = temp;
    }

    // ======================================================================
    // A merge sort function for the 'elements' array.

    public static SortResult mergeSort(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        int[] count = new int[2];
        doMergeSort(sortedArray, count);
        return new SortResult(sortedArray, count[0], count[1]);
    }

    private static void doMergeSort(int[] array, int[] count) {
        int numValues = array.length;
        if (numValues < 2) {
            return;
        }
        int mid = numValues / 2;
        int[] left = new int[mid];
        int[] right = new int[numValues - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, numValues - mid);

        doMergeSort(left, count);
        doMergeSort(right, count);

        merge(array, left, right, count);
    }

    private static void merge(int[] array, int[] left, int[] right, int[] count) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            count[0]++;
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
                count[1]++;
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
