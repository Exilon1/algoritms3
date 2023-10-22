package sortlevel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortLevel {

    public static void SelectionSortStep(int[] array, int i) {
        int index = findMinValIndex(array, i + 1, 1);
        if (array[index] < array[i]) {
            int val = array[i];
            array[i] = array[index];
            array[index] = val;
        }
    }

    public static boolean BubbleSortStep(int[] array) {
        boolean isNotChanged = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int val = array[i];
                array[i] = array[i + 1];
                array[i + 1] = val;
                isNotChanged = false;
            }
        }

        return isNotChanged;
    }

    public static void InsertionSortStep(int[] array, int step, int i) {
        for (int j = i; j < array.length - step; j += step) {
            int index = findMinValIndex(array, j + step, step);

            if (array[index] < array[j]) {
                int val = array[j];
                array[j] = array[index];
                array[index] = val;
            }
        }
    }

    public static ArrayList KnuthSequence(int array_size) {
        return (ArrayList) IntStream.iterate(1, i -> 3 * i + 1)
                .takeWhile(v -> (array_size == 1 && v == 1) || (v < array_size))
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    private static int findMinValIndex(int[] array, int start, int step) {
        int index = start;
        for (int i = start; i < array.length; i += step) {
            if (array[i] < array[index]) {
                index = i;
            }
        }

        return index;
    }
}
