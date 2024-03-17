package org.example.program10;

// This static class defines a "home" for the following n^2 sorting algorithms:
// - Bubble sort
// - Selection sort
// - Insertion sort


import java.util.Arrays;

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

        // Make a copy of the array to sort
        int[] arrayToSort = Arrays.copyOf(array, array.length);

        int[] count = new int[2];

        for (int index = 1; index < arrayToSort.length; index++) {
            int key = arrayToSort[index];
            int position = index;
            while (position > 0 && arrayToSort[position - 1] > key) {
                count[0]++;
                arrayToSort[position] = arrayToSort[position - 1];
                position--;
                count[1]++;
            }
            arrayToSort[position] = key;
        }
        return new SortResult(arrayToSort, count[0], count[1]);
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