package sortlevel;

public class SortLevel {

    public static void SelectionSortStep(int[] array, int i) {
        int index = findIndexMinVal(array, i + 1);
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

    private static int findIndexMinVal(int[] array, int start) {
        int index = start;
        for (int i = start; i < array.length; i++) {
            if (array[i] < array[index]) {
                index = i;
            }
        }

        return index;
    }
}
