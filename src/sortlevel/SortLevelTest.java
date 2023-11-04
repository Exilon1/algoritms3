package sortlevel;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SortLevelTest {

    @Test
    void selectionSortStepTest() {
        int[] arr = new int[] {4,3,1,2};
        int[] sortedArr = new int[] {1,2,3,4};

        for (int i = 0; i < arr.length - 1; i++) {
            SortLevel.SelectionSortStep(arr, i);
        }

        assertEquals(sortedArr.length, arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], sortedArr[i]);
        }
    }

    @Test
    void bubbleSortStepTest() {
        int[] arr = new int[] {4,3,1,2};
        int[] sortedArr = new int[] {1,2,3,4};

        while (! SortLevel.BubbleSortStep(arr)) {}

        assertEquals(sortedArr.length, arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(sortedArr[i], arr[i]);
        }
    }

    @Test
    void insertionSortStepTest() {
        int[] arr = new int[] {7,6,5,4,3,2,1};
        int[] firstStep = new int[] {1,6,5,4,3,2,7};
        int[] secondStep = new int[] {1,3,5,4,6,2,7};
        int[] thirdStep = new int[] {1,3,2,4,6,5,7};

        SortLevel.InsertionSortStep(arr, 3, 0);

        assertEquals(firstStep.length, arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(firstStep[i], arr[i]);
        }

        SortLevel.InsertionSortStep(arr, 3, 1);

        assertEquals(secondStep.length, arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(secondStep[i], arr[i]);
        }

        SortLevel.InsertionSortStep(arr, 3, 2);

        assertEquals(thirdStep.length, arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(thirdStep[i], arr[i]);
        }

        SortLevel.InsertionSortStep(arr, 3, 3);

        assertEquals(thirdStep.length, arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(thirdStep[i], arr[i]);
        }
    }

    @Test
    void knuthSequenceTest() {
        int[] first = new int[] {1};
        int[] second = new int[] {4,1};
        int[] third = new int[] {13,4,1};
        int[] fourth = new int[] {40,13,4,1};
        int[] fifth = new int[] {121,40,13,4,1};

        ArrayList list = SortLevel.KnuthSequence(1);

        assertEquals(first.length, list.size());
        for (int i = 0; i < first.length; i++) {
            assertEquals(first[i], list.get(i));
        }

        list = SortLevel.KnuthSequence(4);

        assertEquals(first.length, list.size());
        for (int i = 0; i < first.length; i++) {
            assertEquals(first[i], list.get(i));
        }

        list = SortLevel.KnuthSequence(5);

        assertEquals(second.length, list.size());
        for (int i = 0; i < second.length; i++) {
            assertEquals(second[i], list.get(i));
        }

        list = SortLevel.KnuthSequence(13);

        assertEquals(second.length, list.size());
        for (int i = 0; i < second.length; i++) {
            assertEquals(second[i], list.get(i));
        }

        list = SortLevel.KnuthSequence(14);

        assertEquals(third.length, list.size());
        for (int i = 0; i < third.length; i++) {
            assertEquals(third[i], list.get(i));
        }

        list = SortLevel.KnuthSequence(40);

        assertEquals(third.length, list.size());
        for (int i = 0; i < third.length; i++) {
            assertEquals(third[i], list.get(i));
        }

        list = SortLevel.KnuthSequence(41);

        assertEquals(fourth.length, list.size());
        for (int i = 0; i < fourth.length; i++) {
            assertEquals(fourth[i], list.get(i));
        }

        list = SortLevel.KnuthSequence(121);

        assertEquals(fourth.length, list.size());
        for (int i = 0; i < fourth.length; i++) {
            assertEquals(fourth[i], list.get(i));
        }

        list = SortLevel.KnuthSequence(122);

        assertEquals(fifth.length, list.size());
        for (int i = 0; i < fifth.length; i++) {
            assertEquals(fifth[i], list.get(i));
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

        assertEquals(sortedArr.length, arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(sortedArr[i], arr[i]);
        }
    }

    @Test
    void arrayChunkTest() {
        int[] arr = new int[] {7,5,6,4,3,1,2};
        int[] sortedArr = new int[] {2,1,3,4,6,5,7};

        assertEquals(3, SortLevel.ArrayChunk(arr));

        assertEquals(sortedArr.length, arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(sortedArr[i], arr[i]);
        }
    }

    @Test
    void quickSortTest() {
        int[] arr = new int[] {5,6,4,3,1,2};
        int[] sortedArr = new int[] {1,2,3,4,5,6};

        SortLevel.QuickSort(arr, 0, arr.length - 1);

        assertEquals(sortedArr.length, arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(sortedArr[i], arr[i]);
        }

        arr = new int[] {7,5,6,4,3,1,2};
        sortedArr = new int[] {1,2,3,4,5,6,7};

        SortLevel.QuickSort(arr, 0, arr.length - 1);

        assertEquals(sortedArr.length, arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(sortedArr[i], arr[i]);
        }
    }

    @Test
    void quickSortTailOptimizationTest() {
        int[] arr = new int[] {5,6,4,3,1,2};
        int[] sortedArr = new int[] {1,2,3,4,5,6};

        SortLevel.QuickSortTailOptimization(arr, 0, arr.length - 1);

        assertEquals(sortedArr.length, arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(sortedArr[i], arr[i]);
        }

        arr = new int[] {7,5,6,4,3,1,2};
        sortedArr = new int[] {1,2,3,4,5,6,7};

        SortLevel.QuickSortTailOptimization(arr, 0, arr.length - 1);

        assertEquals(sortedArr.length, arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(sortedArr[i], arr[i]);
        }
    }

    @Test
    void kthOrderStatisticsStepTest() {
        int[] arr = new int[] {7,5,6,4,3,1,2};
        int[] sortedArr = new int[] {1,2,3,4,5,6,7};

        ArrayList list = SortLevel.KthOrderStatisticsStep(arr, 0, arr.length - 1, 6);

        assertFalse(list.isEmpty());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(7, arr[(int) list.get(i)]);
        }

        list = SortLevel.KthOrderStatisticsStep(arr, 0, arr.length - 1, 0);

        assertFalse(list.isEmpty());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(1, arr[(int) list.get(i)]);
        }

        list = SortLevel.KthOrderStatisticsStep(arr, 0, arr.length - 1, 3);

        assertFalse(list.isEmpty());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(4, arr[(int) list.get(i)]);
        }
    }
}
