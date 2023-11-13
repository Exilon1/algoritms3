package sortlevel;

class HeapSort {

    public Heap HeapObject = new Heap();

    public HeapSort(int[] arr) {
        int depth = (int) (Math.log(arr.length) / Math.log(2));

        HeapObject.MakeHeap(new int[0], depth);

        for (int i = 0; i < arr.length; i++) {
            HeapObject.Add(arr[i]);
        }
    }

    public int GetNextMax() {
        return HeapObject.GetMax();
    }
}
