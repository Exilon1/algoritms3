package sortlevel;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        int[] arr = new int[] {5,6,7,4,1,2,3};
        int[] sortedArr = new int[] {3,2,1,4,7,6,5};

        ArrayList list = SortLevel.KthOrderStatisticsStep(arr, 0, arr.length - 1, 0);

        assertFalse(list.isEmpty());
        assertEquals(0, list.get(0));
        assertEquals(2, list.get(1));

        for (int i = 0; i < arr.length; i++) {
            assertEquals(sortedArr[i], arr[i]);
        }

        sortedArr = new int[] {1,2,3,4,7,6,5};
        list = SortLevel.KthOrderStatisticsStep(arr, (Integer) list.get(0), (Integer) list.get(1), 0);

        assertFalse(list.isEmpty());
        assertEquals(0, list.get(0));
        assertEquals(0, list.get(1));

        for (int i = 0; i < arr.length; i++) {
            assertEquals(sortedArr[i], arr[i]);
        }
    }

    @Test
    void mergeSortTest() {
        ArrayList arr = new ArrayList(List.of(5,6,4,3,1,2));
        ArrayList sortedArr = new ArrayList(List.of(1,2,3,4,5,6));

        ArrayList list = SortLevel.MergeSort(arr);

        assertEquals(sortedArr.size(), list.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(sortedArr.get(i), list.get(i));
        }

        arr = new ArrayList(List.of(2, 1, 1, 1, 7, 6, 5, 4, 3));
        sortedArr = new ArrayList(List.of(1, 1, 1, 2, 3, 4, 5, 6, 7));

        list = SortLevel.MergeSort(arr);

        assertEquals(sortedArr.size(), list.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(sortedArr.get(i), list.get(i));
        }
    }

    @Test
    void heapSortTest() {
        int[] arr = new int[] {2, 1, 1, 7, 6, 5, 4, 3};

        HeapSort heapSort = new HeapSort(arr);

        assertEquals(7, heapSort.GetNextMax());
        assertEquals(6, heapSort.GetNextMax());
        assertEquals(5, heapSort.GetNextMax());
        assertEquals(4, heapSort.GetNextMax());
        assertEquals(3, heapSort.GetNextMax());
        assertEquals(2, heapSort.GetNextMax());
        assertEquals(1, heapSort.GetNextMax());
        assertEquals(1, heapSort.GetNextMax());
    }

    @Test
    void ksortTest() {
        String s1 = "a00";
        String s2 = "h00";
        String s3 = "a99";
        String s4 = "h99";

        String s5 = "h100";
        String s6 = "ab5";
        String s7 = "000";
        String s8 = "aaa";

        ksort ksort = new ksort();

        assertEquals(0, ksort.index(s1));
        assertTrue(ksort.index(s2) > 0 && ksort.index(s2) < 799);
        assertTrue(ksort.index(s3) > 0 && ksort.index(s3) < 799);
        assertEquals(799, ksort.index(s4));

        assertEquals(-1, ksort.index(s5));
        assertEquals(-1, ksort.index(s6));
        assertEquals(-1, ksort.index(s7));
        assertEquals(-1, ksort.index(s8));

        assertTrue(ksort.add(s1));
        assertTrue(ksort.add(s2));
        assertTrue(ksort.add(s3));
        assertTrue(ksort.add(s4));

        assertEquals(s1, ksort.items[0]);
        assertEquals(s4, ksort.items[799]);

        assertEquals(164, ksort.index("b64"));
        assertEquals(100, ksort.index("b00"));
        assertEquals(1, ksort.index("a01"));
        assertEquals(101, ksort.index("b01"));
        assertEquals(199, ksort.index("b99"));
        assertEquals(99, ksort.index("a99"));
    }

    @Test
    void binarySearchTest() {
        int[] arr = new int[] {1,2,3,4,5,6,7};
        BinarySearch binarySearch = new BinarySearch(arr);

        binarySearch.Step(1);

        assertEquals(0, binarySearch.Left);
        assertEquals(2, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(1);

        assertEquals(0, binarySearch.Left);
        assertEquals(0, binarySearch.Right);
        assertEquals(1, binarySearch.GetResult());

        arr = new int[] {1,2,3,4,5,6,7};
        binarySearch = new BinarySearch(arr);

        binarySearch.Step(0);

        assertEquals(0, binarySearch.Left);
        assertEquals(2, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(0);

        assertEquals(0, binarySearch.Left);
        assertEquals(0, binarySearch.Right);
        assertEquals(-1, binarySearch.GetResult());

        arr = new int[] {1,2,3,4,5,6,7};
        binarySearch = new BinarySearch(arr);

        binarySearch.Step(8);

        assertEquals(4, binarySearch.Left);
        assertEquals(6, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(8);

        assertEquals(6, binarySearch.Left);
        assertEquals(6, binarySearch.Right);
        assertEquals(-1, binarySearch.GetResult());

        arr = new int[] {1,2,3,4,5,6,7};
        binarySearch = new BinarySearch(arr);

        binarySearch.Step(4);

        assertEquals(0, binarySearch.Left);
        assertEquals(arr.length - 1, binarySearch.Right);
        assertEquals(1, binarySearch.GetResult());

        arr = new int[] {1,2,3,4,5,6,7,8};
        binarySearch = new BinarySearch(arr);

        binarySearch.Step(1);

        assertEquals(0, binarySearch.Left);
        assertEquals(2, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(1);

        assertEquals(0, binarySearch.Left);
        assertEquals(0, binarySearch.Right);
        assertEquals(1, binarySearch.GetResult());

        arr = new int[] {1,2,3,4,5,6,7,8};
        binarySearch = new BinarySearch(arr);

        binarySearch.Step(0);

        assertEquals(0, binarySearch.Left);
        assertEquals(2, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(0);

        assertEquals(0, binarySearch.Left);
        assertEquals(0, binarySearch.Right);
        assertEquals(-1, binarySearch.GetResult());

        arr = new int[] {1,2,3,4,5,6,7};
        binarySearch = new BinarySearch(arr);

        binarySearch.Step(5);

        assertEquals(4, binarySearch.Left);
        assertEquals(6, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(5);

        assertEquals(4, binarySearch.Left);
        assertEquals(4, binarySearch.Right);
        assertEquals(1, binarySearch.GetResult());

        binarySearch.Step(5);

        assertEquals(4, binarySearch.Left);
        assertEquals(4, binarySearch.Right);
        assertEquals(1, binarySearch.GetResult());

        arr = new int[] {1,2,3,4,5,6,7,8};
        binarySearch = new BinarySearch(arr);

        binarySearch.Step(5);

        assertEquals(4, binarySearch.Left);
        assertEquals(7, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(5);

        assertEquals(4, binarySearch.Left);
        assertEquals(4, binarySearch.Right);
        assertEquals(1, binarySearch.GetResult());

        arr = new int[] {1,2,3,4,5,6,7,8};
        binarySearch = new BinarySearch(arr);

        binarySearch.Step(8);

        assertEquals(4, binarySearch.Left);
        assertEquals(7, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(8);

        assertEquals(6, binarySearch.Left);
        assertEquals(7, binarySearch.Right);
        assertEquals(1, binarySearch.GetResult());

        arr = new int[] {1};
        binarySearch = new BinarySearch(arr);

        binarySearch.Step(1);

        assertEquals(0, binarySearch.Left);
        assertEquals(0, binarySearch.Right);
        assertEquals(1, binarySearch.GetResult());

        binarySearch.Step(0);

        assertEquals(0, binarySearch.Left);
        assertEquals(0, binarySearch.Right);
        assertEquals(-1, binarySearch.GetResult());

        binarySearch.Step(-1);

        assertEquals(0, binarySearch.Left);
        assertEquals(0, binarySearch.Right);
        assertEquals(-1, binarySearch.GetResult());

        arr = new int[] {1,2};
        binarySearch = new BinarySearch(arr);

        binarySearch.Step(0);

        assertEquals(0, binarySearch.Left);
        assertEquals(0, binarySearch.Right);
        assertEquals(-1, binarySearch.GetResult());

        arr = new int[] {1,2};
        binarySearch = new BinarySearch(arr);

        binarySearch.Step(1);

        assertEquals(0, binarySearch.Left);
        assertEquals(1, binarySearch.Right);
        assertEquals(1, binarySearch.GetResult());

        arr = new int[] {1,2};
        binarySearch = new BinarySearch(arr);

        binarySearch.Step(2);

        assertEquals(1, binarySearch.Left);
        assertEquals(1, binarySearch.Right);
        assertEquals(1, binarySearch.GetResult());

        arr = new int[] {1,2};
        binarySearch = new BinarySearch(arr);

        binarySearch.Step(3);

        assertEquals(1, binarySearch.Left);
        assertEquals(1, binarySearch.Right);
        assertEquals(-1, binarySearch.GetResult());

        arr = new int[99];
        for (int i = 1; i < 100; i++) {
            arr[i-1] = i;
        }
        binarySearch = new BinarySearch(arr);

        binarySearch.Step(49);

        assertEquals(0, binarySearch.Left);
        assertEquals(48, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(49);

        assertEquals(25, binarySearch.Left);
        assertEquals(48, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(49);

        assertEquals(37, binarySearch.Left);
        assertEquals(48, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(49);

        assertEquals(43, binarySearch.Left);
        assertEquals(48, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(49);

        assertEquals(46, binarySearch.Left);
        assertEquals(48, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(49);

        assertEquals(48, binarySearch.Left);
        assertEquals(48, binarySearch.Right);
        assertEquals(1, binarySearch.GetResult());

        arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i*2;
        }
        binarySearch = new BinarySearch(arr);

        binarySearch.Step(5);

        assertEquals(0, binarySearch.Left);
        assertEquals(3, binarySearch.Right);
        assertEquals(0, binarySearch.GetResult());

        binarySearch.Step(5);

        assertEquals(2, binarySearch.Left);
        assertEquals(3, binarySearch.Right);
        assertEquals(-1, binarySearch.GetResult());
    }

    @Test
    void gallopingSearchTest() {
        int[] arr = new int[99];
        for (int i = 1; i < 100; i++) {
            arr[i-1] = i;
        }
        BinarySearch binarySearch = new BinarySearch(arr);

        assertTrue(binarySearch.GallopingSearch(arr, 1));

        binarySearch = new BinarySearch(arr);

        assertTrue(binarySearch.GallopingSearch(arr, 50));

        binarySearch = new BinarySearch(arr);

        assertTrue(binarySearch.GallopingSearch(arr, 99));

        binarySearch = new BinarySearch(arr);

        assertFalse(binarySearch.GallopingSearch(arr, 0));

        binarySearch = new BinarySearch(arr);

        assertFalse(binarySearch.GallopingSearch(arr, 100));

        arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i*2;
        }

        binarySearch = new BinarySearch(arr);

        assertFalse(binarySearch.GallopingSearch(arr, 9));
    }
}
