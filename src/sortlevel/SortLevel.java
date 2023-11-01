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

    public static int ArrayChunk(int[] M) {
        int index;

        out:
        while (true) {
            index = M.length /2;
            int n = M[index];

            int iOne = 0;
            int iTwo = M.length - 1;

            while (true) {
                while (M[iOne] < n) {
                    iOne++;
                }

                while (M[iTwo] > n) {
                    iTwo--;
                }

                if (iOne == iTwo - 1 && M[iOne] > M[iTwo]) {
                    int val = M[iOne];
                    M[iOne] = M[iTwo];
                    M[iTwo] = val;

                    continue out;
                }

                if (iOne == iTwo || (iOne == iTwo - 1 && M[iOne] < M[iTwo])) {
                    break out;
                }

                int val = M[iOne];
                M[iOne] = M[iTwo];
                M[iTwo] = val;

                if (iOne == index) {
                    index = iTwo;
                    continue;
                }

                if (iTwo == index) {
                    index = iOne;
                }
            }
        }

        return index;
    }

    public static void QuickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int index = quickSortStep(array, left, right);

        QuickSort(array, left, index - 1);
        QuickSort(array, index + 1, right);
    }

    public static void QuickSortTailOptimization(int[] array, int left, int right) {

        while (left < right) {
            int index = quickSortStep(array, left, right);

            if (index - left < right - index) {
                QuickSortTailOptimization(array, left, index - 1);
                left = index + 1;
            } else {
                QuickSortTailOptimization(array, index + 1, right);
                right = index - 1;
            }
        }
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

    private static int quickSortStep(int[] array, int left, int right) {
        int index;

        out:
        while (true) {
            index = (left + right + 1)/2;
            int n = array[index];

            int iOne = left;
            int iTwo = right;

            while (true) {
                while (array[iOne] < n) {
                    iOne++;
                }

                while (array[iTwo] > n) {
                    iTwo--;
                }

                if (iOne == iTwo - 1 && array[iOne] > array[iTwo]) {
                    int val = array[iOne];
                    array[iOne] = array[iTwo];
                    array[iTwo] = val;

                    continue out;
                }

                if (iOne == iTwo || (iOne == iTwo - 1 && array[iOne] < array[iTwo])) {
                    break out;
                }

                int val = array[iOne];
                array[iOne] = array[iTwo];
                array[iTwo] = val;

                if (iOne == index) {
                    index = iTwo;
                    continue;
                }

                if (iTwo == index) {
                    index = iOne;
                }
            }
        }

        return index;
    }
}
