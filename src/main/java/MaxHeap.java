import java.util.Arrays;
public final class MaxHeap<T extends Comparable <? super T>>
        implements MaxHeapInterface<T> {
    private T[] heap;   // Array of Heap entries
    private int lastIndex;  // Index of last entry
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 100;
    private static final int MAX_CAPACITY = 10000;


}