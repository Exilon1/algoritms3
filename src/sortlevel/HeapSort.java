package sortlevel;

public class HeapSort {

    public Heap HeapObject = new Heap();

    public HeapSort(int[] arr) {
        int size = (int) (Math.log(arr.length) / Math.log(2));

        HeapObject.MakeHeap(arr, size);
    }

    public int GetNextMax() {
        return HeapObject.GetMax();
    }
}
