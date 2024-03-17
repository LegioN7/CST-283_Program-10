package org.example.program10;

// CST-283
// Aaron Pelto
// Winter 2024

/*
    Write a program to compare the relative performance of different sorting algorithms on three datasets
    containing integers 1..100. Ultimately, the data should be sorted in ascending order. The three
    input datasets are respectively sorted:
        inverse.txt (in opposite order - descending) Access to all three files
        random.txt (randomly) this link
        almost.txt (almost in order - ascending)
    You should include the following sorting algorithms in your analysis. Feel free to place all of these in
    the same file. This is an analysis problem, not a structured software solution.
        N^2 Sorting Algorithms (found here)
            Selection Sort
            Bubble Sort
            Insertion Sort
            Bubble Sort2 (abbreviated Bubble Sort - found here)
        N log2 N Sorting Algorithms (found here)
            Heap Sort
            QuickSort
            MergeSort (requires an online search; not included in course materials)
    To measure the performance of the various sorting routines, count the number of comparisons and
    swaps required to achieve the desired ascending sorted order.

    You will be required to perform this analysis for all sorting routines for all three datasets.
    Be sure to measure compares as occurrences in each algorithm where array elements themselves are compared.
    Some algorithms compare counters as part of the algorithm.
    These should not be included in the count of compares.

    You should use global variables as counters. This is required for the recursive algorithms.
    Place all functions in one file, if necessary.

    For counting the comparisons, consider each place in each algorithm where an expression exists such as
        if (array[] > array[]) where an array element is compared to another.
        Swaps in the algorithms use an included function swap().
    Be sure to utilize two separate counters; one for total swaps and one for total comparisons.

    Consider this similar to a science lab experiment where you are asked to document your outcomes
    and draw conclusions.
    To summarize your results, a worksheet is provided with a format for reporting the results.
    You may use this worksheet or enter the same information (and short conclusion) in your own format.
    Your conclusion should include a general reaction to the results of the experiment.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.program10.SortingN2.*;

public class SortingPerformance extends Application {
    private TextArea testResultsArea;

    // Load data from the files
    public static int[] readFile(String fileName) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            list.add(Integer.parseInt(line.trim()));
        }
        br.close();
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    public void setTestResults(String text) {
        testResultsArea.setText(text);
    }

    private void startSortFunction() throws IOException {
        // Files to read
        // Held in an array for easy iteration
        String[] files = {"inverse.txt", "random.txt", "almost.txt"};

        // N2 Arrays
        // Read the files into arrays
        // 2D array to hold the arrays for each file
        int[][] arraysForN2 = new int[files.length][];
        // Read the files into the arrays
        for (int i = 0; i < files.length; i++) {
            arraysForN2[i] = readFile(files[i]);
        }

        // Nlog2N Arrays
        int[][] arraysForNlog2N = new int[files.length][];
        for (int i = 0; i < files.length; i++) {
            arraysForNlog2N[i] = readFile(files[i]);
        }

        // Class to hold the results of the sorting algorithms
        SortResult sortResult;

        // Sorting N2 Algorithms and methods
        this.testResultsArea.appendText("\nN^2 Sorting Algorithms\n");
        for (int i = 0; i < files.length; i++) {
            this.testResultsArea.appendText(files[i] + "\n");

            int[] arrayForSelectionSort = Arrays.copyOf(arraysForN2[i], arraysForN2[i].length);
            sortResult = selectionSort(arrayForSelectionSort);
            this.testResultsArea.appendText("Selection Sort on " + files[i] + " took " + sortResult.getComparisons() + " comparisons and " + sortResult.getSwaps() + " swaps.\n");

            int[] arrayForBubbleSort = Arrays.copyOf(arraysForN2[i], arraysForN2[i].length);
            sortResult = bubbleSort(arrayForBubbleSort);
            this.testResultsArea.appendText("Bubble Sort on " + files[i] + " took " + sortResult.getComparisons() + " comparisons and " + sortResult.getSwaps() + " swaps.\n");

            int[] arrayForInsertionSort = Arrays.copyOf(arraysForN2[i], arraysForN2[i].length);
            sortResult = insertionSort(arrayForInsertionSort);
            this.testResultsArea.appendText("Insertion Sort on " + files[i] + " took " + sortResult.getComparisons() + " comparisons and " + sortResult.getSwaps() + " swaps.\n");

            int[] arrayForShortBubbleSort = Arrays.copyOf(arraysForN2[i], arraysForN2[i].length);
            sortResult = SortingN2.shortBubbleSort(arrayForShortBubbleSort);
            this.testResultsArea.appendText("Short Bubble Sort on " + files[i] + " took " + sortResult.getComparisons() + " comparisons and " + sortResult.getSwaps() + " swaps.\n");

            this.testResultsArea.appendText("\n");
        }

        // Sorting Nlog2N Algorithms and methods
        this.testResultsArea.appendText("\nN log2 N Sorting Algorithms\n");
        for (int i = 0; i < files.length; i++) {
            this.testResultsArea.appendText(files[i] + "\n");

            int[] arrayForHeapSort = Arrays.copyOf(arraysForNlog2N[i], arraysForNlog2N[i].length);
            sortResult = SortingNlog2N.heapSort(arrayForHeapSort);
            this.testResultsArea.appendText("Heap Sort on " + files[i] + " took " + sortResult.getComparisons() + " comparisons and " + sortResult.getSwaps() + " swaps.\n");

            int[] arrayForQuickSort = Arrays.copyOf(arraysForNlog2N[i], arraysForNlog2N[i].length);
            sortResult = SortingNlog2N.quickSort(arrayForQuickSort);
            this.testResultsArea.appendText("Quick Sort on " + files[i] + " took " + sortResult.getComparisons() + " comparisons and " + sortResult.getSwaps() + " swaps.\n");

            int[] arrayForMergeSort = Arrays.copyOf(arraysForNlog2N[i], arraysForNlog2N[i].length);
            sortResult = SortingNlog2N.mergeSort(arrayForMergeSort);
            this.testResultsArea.appendText("Merge Sort on " + files[i] + " took " + sortResult.getComparisons() + " comparisons and " + sortResult.getSwaps() + " swaps.\n");

            this.testResultsArea.appendText("\n");
        }
    }

    @Override
    public void start(Stage stage) {
        testResultsArea = new TextArea();
        // Use monospaced font
        testResultsArea.setStyle("-fx-font-family: monospace");
        // Use the full height of the VBox
        testResultsArea.prefHeightProperty().bind(stage.heightProperty());

        // Create Start button
        Button startButton = new Button("Start");
        startButton.setOnAction(e -> {
            try {
                startSortFunction();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        // Create Quit button
        Button quitButton = new Button("Quit");
        quitButton.setOnAction(e -> {
            stage.close();
        });

        VBox vbox = new VBox(startButton, quitButton, testResultsArea);

        Scene scene = new Scene(vbox, 720, 720);
        stage.setTitle("Sorting Performance");
        stage.setScene(scene);
        stage.show();
    }

}
