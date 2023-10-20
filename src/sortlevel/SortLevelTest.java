package sortlevel;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

    @Test
    void knuthSequenceTest() {
        int[] first = new int[] {13,4,1};
        int[] second = new int[] {40,13,4,1};
        int[] third = new int[] {121,40,13,4,1};

        ArrayList list = SortLevel.KnuthSequence(3);

        for (int i = 0; i < first.length; i++) {
            assertEquals(list.get(i), first[i]);
        }

        list = SortLevel.KnuthSequence(4);

        for (int i = 0; i < second.length; i++) {
            assertEquals(list.get(i), second[i]);
        }

        list = SortLevel.KnuthSequence(5);

        for (int i = 0; i < third.length; i++) {
            assertEquals(list.get(i), third[i]);
        }

        int[] arr = new int[] {15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        int[] sortedArr = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        list = SortLevel.KnuthSequence(15);

        // Shell sort
        list.forEach(v -> {
            for (int i = 0; i < (Integer) v; i++) {
                SortLevel.InsertionSortStep(arr, (Integer) v, i);
            }
        });

        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], sortedArr[i]);
        }
    }
}
