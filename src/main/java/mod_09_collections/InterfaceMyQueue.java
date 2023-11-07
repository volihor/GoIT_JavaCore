package mod_09_collections;

public interface InterfaceMyQueue<E> extends InterfaceMyCollection<E> {

//    /**
//     * Inserts the specified element into this queue if it is possible to do so
//     * immediately without violating capacity restrictions, returning
//     * {@code true} upon success and throwing an {@code IllegalStateException}
//     * if no space is currently available.
//     *
//     * @param e the element to add
//     * @return {@code true} (as specified by {@link Collection#add})
//     */
//    boolean add(E e);

//    /**
//     * Removes the head of this queue.  This method differs
//     * from {@link #poll poll} only in that it throws an exception if this
//     * queue is empty.
//     */
//     clear();
//
//    /**
//     * Return the sizw of queue
//     */
//    public int size();

/*    Summary of Queue methods
    Returns special value

    Insert    add(e)       offer(e)
    Remove    remove()     poll()
    Examine   element()    peek()
 */

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    E poll();

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    E peek();

}
