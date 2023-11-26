package sortlevel;

import java.math.BigInteger;

public class BinarySearch {

    public int Left;
    public int Right;
    private int[] sortedArr;
    private Boolean found;


    public BinarySearch(int[] sortedArr) {
        init(sortedArr);
    }

    private void init(int[] sortedArr) {
        Left = 0;
        Right = sortedArr.length - 1;
        found = null;
        this.sortedArr = sortedArr;
    }

    public void Step(int N) {
        int index = (Left + Right)/2;

         if (sortedArr[index] == N) {
             found = true;
             return;
         }

         if (sortedArr[index] > N) {
             Right = index == 0 ? index : index - 1;
         }

        if (sortedArr[index] < N) {
            Left = index + 1;
        }

        if (((Left == Right) && sortedArr[Right] == N) ||
                (Right - Left == 1 && sortedArr[Left] == N) ||
                (Right - Left == 1 && sortedArr[Right] == N)) {
            found = true;
            return;
        }

        if (((Left == Right) && sortedArr[Right] != N) ||
                (Right - Left == 1 && sortedArr[Left] != N) ||
                (Right - Left == 1 && sortedArr[Right] != N)) {
            found = false;
        }
    }

    public int GetResult() {
        if (found == null) {
            return 0;
        }

        if (found) {
            return 1;
        }

        return -1;
    }

    public boolean GallopingSearch(int[] sortedArr, int N) {
        init(sortedArr);

        int maxIndex = (int) (Math.log(sortedArr.length + 1) / Math.log(2) + 1);
        boolean insideRange = false;

        for (int i = 1; i <= maxIndex; i++) {
            int index = new BigInteger(String.valueOf(2)).pow(i).subtract(BigInteger.valueOf(2)).intValue();

            if (index > sortedArr.length - 1) {
                index = sortedArr.length - 1;
            }

            if (sortedArr[index] == N) {
                return true;
            }

            if (sortedArr[index] < N) {
                continue;
            }

            if (sortedArr[index] > N) {
                Right = index;
                Left = new BigInteger(String.valueOf(2)).pow(i - 1).subtract(BigInteger.valueOf(1)).intValue();
                insideRange = true;
                break;
            }
        }

        if (! insideRange) {
            return false;
        }

        while (found == null) {
            Step(N);
        }

        return found;
    }
}
