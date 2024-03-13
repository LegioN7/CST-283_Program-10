package org.example.program10;

// This static class defines a "home" for the following n^2 sorting algorithms:
// - Bubble sort
// - Selection sort
// - Insertion sort


public class SortingN2 {


    // Bubble sort on an array of integers (ascending)
    public static SortResult bubbleSort(int[] array) {
        int lastPos;
        int index;
        int temp;
        int comparisons = 0;
        int swaps = 0;

        for (lastPos = array.length - 1; lastPos >= 0; lastPos--) {
            for (index = 0; index <= lastPos - 1; index++) {
                comparisons++;
                if (array[index] > array[index + 1]) {
                    temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                    swaps++;
                }
            }
        }
        return new SortResult(array, comparisons, swaps);
    }

    // Selection sort on an array of integers (ascending)
    public static SortResult selectionSort(int[] array) {
        int startScan;
        int index;
        int minIndex;
        int minValue;
        int comparisons = 0;
        int swaps = 0;

        for (startScan = 0; startScan < (array.length - 1); startScan++) {
            minIndex = startScan;
            minValue = array[startScan];

            for (index = startScan + 1; index < array.length; index++) {
                comparisons++;
                if (array[index] < minValue) {
                    minValue = array[index];
                    minIndex = index;
                }
            }

            array[minIndex] = array[startScan];
            array[startScan] = minValue;
            swaps++;
        }
        return new SortResult(array, comparisons, swaps);
    }

    // Insertion sort on an array of integers (ascending)
    public static SortResult insertionSort(int[] array) {
        int unsortedValue;
        int scan;
        int comparisons = 0;
        int swaps = 0;

        for (int index = 1; index < array.length; index++) {
            unsortedValue = array[index];
            scan = index;

            while (scan > 0 && array[scan - 1] > unsortedValue) {
                comparisons++;
                array[scan] = array[scan - 1];
                scan--;
                swaps++;
            }

            array[scan] = unsortedValue;
        }
        return new SortResult(array, comparisons, swaps);
    }

    // Bubble sort on an array of integers (ascending)
    public static SortResult shortBubbleSort(int[] array) {
        boolean swap;
        int temp;
        int comparisons = 0;
        int swaps = 0;

        int end = array.length - 1;

        do {
            swap = false;
            for (int count = 0; count < end; count++) {
                comparisons++;
                if (array[count] > array[count + 1]) {
                    temp = array[count];
                    array[count] = array[count + 1];
                    array[count + 1] = temp;
                    swap = true;
                    swaps++;
                }
            }
            end--;
        } while (swap);
        return new SortResult(array, comparisons, swaps);
    }
}