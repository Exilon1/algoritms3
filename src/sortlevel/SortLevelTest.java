package sortlevel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortLevelTest {

    @Test
    void selectionSortStepTest() {
        int[] arr = new int[] {4,3,1,2};
        int[] sortedArr = new int[] {1,2,3,4};

        for (int i = 0; i < arr.length - 1; i++) {
            SortLevel.SelectionSortStep(arr, i);
        }

        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], sortedArr[i]);
        }
    }

    @Test
    void bubbleSortStepTest() {
        int[] arr = new int[] {4,3,1,2};
        int[] sortedArr = new int[] {1,2,3,4};

        while (! SortLevel.BubbleSortStep(arr)) {}

        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], sortedArr[i]);
        }
    }

    @Test
    void insertionSortStepTest() {
        int[] arr = new int[] {7,6,5,4,3,2,1};
        int[] firstStep = new int[] {1,6,5,4,3,2,7};
        int[] secondStep = new int[] {1,3,5,4,6,2,7};
        int[] thirdStep = new int[] {1,3,2,4,6,5,7};

        SortLevel.InsertionSortStep(arr, 3, 0);

        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], firstStep[i]);
        }

        SortLevel.InsertionSortStep(arr, 3, 1);

        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], secondStep[i]);
        }

        SortLevel.InsertionSortStep(arr, 3, 2);

        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], thirdStep[i]);
        }

        SortLevel.InsertionSortStep(arr, 3, 3);

        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], thirdStep[i]);
        }
    }
}
