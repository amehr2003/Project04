public interface MaxHeapInterface <T extends Comparable<? super T>> {
    /**
     * clears contents of the MaxHeap
     */
    public void clear();

    /**
     * returns int containing the size of the MaxHeap
     */
    public int getSize();

    /**
     * adds a new object entry to the MaxHeap
     */
    public void add(T newEntry);

    /**
     *  returns the max object of the MaxHeap
     */
    public T getMax();

    /**
     * removes the max entry from the MaxHeap and returns the object
     */
    public T removeMax();
}
