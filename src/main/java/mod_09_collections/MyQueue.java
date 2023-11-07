package mod_09_collections;

import java.util.Arrays;

public class MyQueue<E> implements InterfaceMyQueue<E> {
    private static final int MIN_INITIAL_CAPACITY = 4; // Default initial capacity.
    private E[] queueArray ;
    private int lengthQueArray;
    private int size =0;
    // The index of the element at the head of the deque (which is the element that would be removed by remove() or pop());
    // or an arbitrary number equal to tail if the deque is empty.
    private int head;
    //The index at which the next element would be added to the tail of the deque (via addLast(E), add(E), or push(E)).
    private int tail;

    public MyQueue(){
        this(MIN_INITIAL_CAPACITY);
    }
    public MyQueue(int capacity){
        if(capacity < MIN_INITIAL_CAPACITY){
            this.queueArray = (E[])new Object[MIN_INITIAL_CAPACITY];
        }else{
            this.queueArray = (E[])new Object[capacity];
        }
        this.lengthQueArray = queueArray.length;

    }

    /* @return <tt>true</tt> if this collection changed as a result of the call */
    public boolean add(E e) {
        if(size == lengthQueArray){          // Queue is full
            System.out.println("Queue is full !!!  Element : " + e + " is NOT added.");
            return false;
        }else if(tail == 0 && size == 0){   // Queue is empty
            queueArray[tail++] = e;
        }else if(tail == lengthQueArray && head != 0) {     // If tail is in the end of queue and there is a
            tail = tail % lengthQueArray;                   // free spase at the begining of queue then write to it.
            queueArray[tail++] = e;
        }else if (tail != head) {
            queueArray[tail++] = e;
        }

        size++;
        return true;
    }
    @Override

    /*
     *  form interface InterfaceMyCollection.
     *  Not implemented
     * */
    public boolean remove(Object o) {
        return false;
    }

    @Override // очищає колекцію
    public void clear() {
        Arrays.fill(queueArray, null);
        head = 0;
        tail = 0;
        size = 0;
    }
    //    Returns the number of elements in this deque
    @Override
    public int size() {
        return size;
    }
    //    Retrieves, but does not remove, the head of the queue , or returns null if this deque is empty.
    @Override
    public E peek() {
        return (E) queueArray[head];
    }

    // Retrieves and removes the head of the queue( the first element of this que), or returns null if this deque is empty.
    @Override
    public E poll() {
        if( size == 0 ){
            System.out.println("Queue is empty !!!");
            return null;
        }
        E elementToReturn = (E) queueArray[head];
        queueArray[head] = null;

        // If head is in the end of queue then head = 0.
        if( head == (lengthQueArray - 1) ) {
            head = 0;
        }
        // If is in the end of queue then head = 0.
        else if (head == tail -1) {
            this.clear();
            return elementToReturn;
        }

        head++;
        size--;
        return elementToReturn;
    }

    @Override
    public String toString(){
        return Arrays.toString(queueArray);
    }
}
