import java.util.Arrays;
public class MaxHeap<T extends Comparable <? super T>>
        implements MaxHeapInterface<T> {
    private T[] heap;   // Array of Heap entries
    private int lastIndex;  // Index of last entry
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 100;
    private static final int MAX_CAPACITY = 10000;

    public static int numSwaps=0;
    public static int oNumSwaps=0;

    private void checkInitialization()
    {
        if (!initialized)
        {
            throw new SecurityException ("MaxHeap object is not initialized properly.");
        }
    } //end checkInitialization

    @Override
    public void clear() {
        checkInitialization();
        while (lastIndex > -1)
        {
            heap[lastIndex] = null;
            lastIndex--;
        } //end while
        lastIndex = 0;
    } //end clear

    public boolean isEmpty()
    {
        return lastIndex < 1;
    } //end is empty

    @Override
    public int getSize() {
        return lastIndex;
    }

    // method for adding to heap using sequential insertions
    @Override
    public void add(T newEntry)
    {
        checkInitialization();
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
        {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
            numSwaps++;
        } // end while
        heap[newIndex] = newEntry;
        lastIndex++;
        checkCapacity(heap.length);
    }

    // method for adding to heap using the optimal method

    @Override
    public void OptimalAdd(T[] optimal)
    {
        lastIndex=optimal.length;
        assert initialized = true; //using assert instead of just =
        for (int i=0; i<lastIndex; i++)
        {
            heap[i+1]=optimal[i];
        }

        for (int j= lastIndex>>=1; j>0; j--)
        {
            reheap(j);
        }
    }


    @Override
    public T getMax() {
        checkInitialization();
        T root = null;
        if( isEmpty() )
            root = heap[1];
        return root;
    } //end getMax;

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
                oNumSwaps++;
            }
            else
                done = true;
        } // end while
        heap[rootIndex] = orphan;
    } // end reheap


    //remove method for MaxHeap
    public T removeMax()
    {
        checkInitialization();; // Ensure initialization of data fields
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


    private void ensureCapacity()
    {
        if (lastIndex >= heap.length)
        {
            int newCapacity = 2 * heap.length;
            checkCapacity(newCapacity);
            heap = Arrays.copyOf(heap, newCapacity);
        }
    } //end ensureCapacity

    private void checkCapacity(int capacity)
    {
        if (capacity < DEFAULT_CAPACITY)
        {
            capacity = DEFAULT_CAPACITY;
        }
        else if (capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to create a heap " +
                    "whose capacity is larger than " +
                    MAX_CAPACITY);
        }
    } //end checkCapacity

    //method to print heap values to help in driver class
    public void printHeapValues()
    {
        for (int i=0; i<=10; i++) //this line isn't done
        {
            System.out.print(", " + heap[i]);
        }
    }

}



