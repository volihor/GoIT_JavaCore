package mod_09_collections;

import java.util.Arrays;

public class MyArrayList<E> implements InterfaceMyList<E> {

    private static final int DEFAULT_CAPACITY = 10; // Default initial capacity.
    private  int capacity;    // The capacity of the ArrayList is the length of this array buffer.
    private  int size;        // The number of elements its contains in the ArrayList.
    private  E[] arrayList;
    public MyArrayList(){
        this(MyArrayList.DEFAULT_CAPACITY);
    }
    public MyArrayList(int initialCapacity) {
        if(initialCapacity > 0 ){
            this.arrayList = (E[]) new Object[initialCapacity];
            this.size = 0;
            this.capacity = arrayList.length;
        }
    }

    @Override //
    public boolean add(E e) {
        if(size == capacity-1){
            capacity += capacity/2;   // index of capacity growth is 1.5
            arrayList = Arrays.copyOf(arrayList, capacity);
        }
        arrayList[size] = e;
        size++;
        return true;
    }


    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override // interface InterfaceMyList
    public E remove(int index) {
        try{
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
        } catch(IndexOutOfBoundsException e){
            System.out.println("\n!!! IndexOutOfBoundsException.  Trying to use wrong index value to remove element !!! \n");
            e.printStackTrace();
        }
        E toReturn = arrayList[index];
        E[] tmpArrayList =(E[]) new Object[capacity];
//                * @param      src      the source array.
//                * @param      srcPos   starting position in the source array.
//                * @param      dest     the destination array.
//                * @param      destPos  starting position in the destination data.
//                * @param      length   the number of array elements to be copied.
        System.arraycopy(arrayList, 0, tmpArrayList, 0, index );
        System.arraycopy(arrayList, index+1, tmpArrayList, index, (capacity -1)-index );

        arrayList = tmpArrayList;
        size--;

        return toReturn;
    }

    @Override // interface InterfaceMyCollection.
    // Not implemented
    public boolean remove(E e) {
        return false;
    }

    //Removes 'all' of the elements from this list. The list will be empty after this call returns./
    @Override //очищає колекцію
    public void clear() {
        arrayList = (E[]) new Object[capacity];
        size = 0;
    }


    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override //повертає розмір колекції
    public int size() {
        return size;
    }

    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns element by index
     */
    public E get(int index) {
        try{
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
        } catch(IndexOutOfBoundsException e){
            System.out.println("\n!!! IndexOutOfBoundsException.  Trying to use wrong index value to get element !!! \n");
            e.printStackTrace();
        }
        return arrayList[index];
    }

    @Override
    public String toString(){
        return Arrays.toString(arrayList);
    }
}
