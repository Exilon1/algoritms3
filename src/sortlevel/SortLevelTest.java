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

        for (int i = 0; i < arr.length - 1; i++) {
            assertEquals(arr[i], sortedArr[i]);
        }
    }

    @Test
    void bubbleSortStepTest() {
        int[] arr = new int[] {4,3,1,2};
        int[] sortedArr = new int[] {1,2,3,4};

        while (! SortLevel.BubbleSortStep(arr)) {}

        for (int i = 0; i < arr.length - 1; i++) {
            assertEquals(arr[i], sortedArr[i]);
        }
    }
}
