package sortlevel;

public class BinarySearch {

    public int Left;
    public int Right;
    private int[] sortedArr;
    private Boolean found;


    public BinarySearch(int[] sortedArr) {
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
            Left = index == sortedArr.length - 1 ? index : index + 1;
        }

        if ((Left == Right) && sortedArr[Right] == N) {
            found = true;
        } else if ((Left == Right) && sortedArr[Right] != N) {
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
}
