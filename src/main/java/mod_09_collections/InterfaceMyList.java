package mod_09_collections;

//import java.util.Collection;

public interface InterfaceMyList<E> extends InterfaceMyCollection<E> {

    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     *
     * @param e element to be appended to this list
     * @return <tt>true</tt> (as specified by {@link #add})
     * @throws UnsupportedOperationException if the <tt>add</tt> operation
     *         is not supported by this list
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this list
     * @throws NullPointerException if the specified element is null and this
     *         list does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this list
     */
    public boolean add(E e);    // додає елемент
//    /**
//     * Inserts the specified element at the specified position in this list
//     * (optional operation).  Shifts the element currently at that position
//     * (if any) and any subsequent elements to the right (adds one to their
//     * indices).
//     *
//     * @param index index at which the specified element is to be inserted
//     * @param element element to be inserted
//     * @throws UnsupportedOperationException if the <tt>add</tt> operation
//     *         is not supported by this list
//     * @throws ClassCastException if the class of the specified element
//     *         prevents it from being added to this list
//     * @throws NullPointerException if the specified element is null and
//     *         this list does not permit null elements
//     * @throws IllegalArgumentException if some property of the specified
//     *         element prevents it from being added to this list
//     * @throws IndexOutOfBoundsException if the index is out of range
//     *         (<tt>index &lt; 0 || index &gt; size()</tt>)
//     */
//    public void add(int index, E element);

    /**
     * Removes the element at the specified position in this list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed from the
     * list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *         is not supported by this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public E remove(int index); // видаляє елемент із вказаним індексом

    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     */
    void clear();

    /**
     * Returns the number of elements in this collection.
     */
    public int size();          // повертає розмір колекції

    /**
     * Returns element by index
     */
    public E get(int index);  // повертає елемент за індексом
}
