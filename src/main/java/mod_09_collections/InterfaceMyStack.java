package mod_09_collections;


public interface InterfaceMyStack<E> extends InterfaceMyCollection<E> {


    /**
     * Pushes an item onto the top of this stack.
     *
     * @param   item   the item to be pushed onto this stack.
     * @return  the <code>item</code> argument.
     **/
    public E push(E item);

    /**
     * Remove element by the index in this stack.
     *
     * @param   index to remove element from this stack.
     * @return  the element argument.
     **/
    public E remove(int index);

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    E peek();

    /**
    * Removes the object at the top of this stack and returns that object as the value of this function.
    * Returns: The object at the top of this stack (the last item of the stack
    **/
    E pop();
}
