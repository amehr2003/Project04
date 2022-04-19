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

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
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

    @Override
    public T getMax() {
        return null;
    }

    private void reheap(int rootIndex)
    {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;
        while (!done && (leftChildIndex <= lastIndex) )
        {
            int largerChildIndex = leftChildIndex; // Assume larger
            int rightChildIndex = leftChildIndex + 1;
            if ( (rightChildIndex <= lastIndex) &&
                    heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
            {
                largerChildIndex = rightChildIndex;
            } // end if
            if (orphan.compareTo(heap[largerChildIndex]) < 0)
            {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            }
            else
                done = true;
        } // end while
        heap[rootIndex] = orphan;
    } // end reheap

    //remove method for MaxHeap
    public T removeMax()
    {
        checkInitilization(); // Ensure initialization of data fields
        T root = null;
        if (!isEmpty())
        {
            root = heap[1]; // Return value
            heap[1] = heap[lastIndex]; // Form a semiheap
            lastIndex--; // Decrease size
            reheap(1); // Transform to a heap
        } // end if
        return root;
    } // end removeMax


}
