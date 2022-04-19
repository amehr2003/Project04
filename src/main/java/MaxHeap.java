import java.util.Arrays;
public final class MaxHeap<T extends Comparable <? super T>>
        implements MaxHeapInterface<T> {
    private T[] heap;   // Array of Heap entries
    private int lastIndex;  // Index of last entry
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 100;
    private static final int MAX_CAPACITY = 10000;
    private int count=0;

    public boolean checkInitilization()
    {
        if ()
        {
            return true;
        }
        return false;
    }

    // method for adding to heap using sequential insertions
    public void add(T NewEntry)
    {
        checkInitilization();
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0){
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
            numSwaps++;
        } // end while
        heap[newIndex] = newEntry;
        lastIndex++;
        checkCapacity(heap.length);

    }

    // method for adding to heap using optimal method

    //remove method for MaxHeap
    public T removeMax()
    {
        return ;
    }


}