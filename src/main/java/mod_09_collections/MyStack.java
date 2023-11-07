package mod_09_collections;

import java.sql.Struct;
import java.util.Arrays;

public class MyStack<E> implements InterfaceMyStack<E> {

//      push(Object value);// додає елемент в кінець
//      remove(int index);
//      clear();
//      size();
//      peek() повертає перший елемент стеку
//      pop() повертає перший елемент стеку та видаляє його з колекції

private static final int MIN_INITIAL_CAPACITY = 4; // Default initial capacity.
    private E[] stackArray;
    private int lengthStackArray;
    private int size =0;
//    // The index of the element at the head of the deque (which is the element that would be removed by remove() or pop());
//    // or an arbitrary number equal to tail if the deque is empty.
//    private int head;
    //The index at which the next element would be added/removed at the top of the stack (via push(E), pop(E)).
    private int top;

    public MyStack(){
        this(MIN_INITIAL_CAPACITY);
    }
    public MyStack(int capacity){
        if(capacity < MIN_INITIAL_CAPACITY){
            this.stackArray = (E[])new Object[MIN_INITIAL_CAPACITY];
        }else{
            this.stackArray = (E[])new Object[capacity];
        }
        this.lengthStackArray = stackArray.length;

    }

    /* @return element if this collection changed as a result of the call
    *   or return null if this collection not changed
    * */
    @Override
    public E push(E e) {
        if(size == lengthStackArray){          // Stack is full
            System.out.println("Stack is full !!!  Element : " + e + " is NOT pushed.");
            return null;
        }else{
            stackArray[top++] = e;
        }
        size++;
        return e;
    }


    /*
     *  form interface InterfaceMyCollection.
     *  Not implemented
     * */
    @Override
    public boolean add(E e){
        return  false;
    }
    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override // очищає колекцію
    public void clear() {
        Arrays.fill(stackArray, null);
        top = 0;
        size = 0;
    }
    //    Returns the number of elements in this stack
    @Override
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return (size == 0)? true : false;
    }

    //    Retrieves, but does not remove, the top of the stack , or returns null if this stack is empty.
    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        else
            return (E)stackArray[top-1];
    }

    // Retrieves and removes the top of the stack( the first element of this stack), or returns null if this stack is empty.
    @Override
    public E pop() {
        if( isEmpty() ){
            System.out.println("Queue is empty !!!");
            return null;
        }
        E elementToReturn = (E) stackArray[top-1];
        stackArray[top-1] = null;

        top--;
        size--;
        return elementToReturn;
    }


    // Remove element by the index in this stack. Return null if this steck was not changed
    // Resize array and coppy all elenemts into a new array.
    @Override
    public E remove(int index) {
        if(index > (size - 1) || index < 0 ) {
            return null;
        }
        E[] newStackArray = (E[])new Object[lengthStackArray];
        E elementToRemove = (E)stackArray[index];

//          * @param      src      the source array.
//          * @param      srcPos   starting position in the source array.
//          * @param      dest     the destination array.
//          * @param      destPos  starting position in the destination data.
//          * @param      length   the number of array elements to be copied.
        System.arraycopy(stackArray, 0, newStackArray, 0, index );
        System.arraycopy(stackArray, index+1, newStackArray, index, (lengthStackArray - 1 ) - index );

        stackArray = newStackArray;
        lengthStackArray = stackArray.length;

        top--;
        size--;
        return elementToRemove;
    }

    @Override
    public String toString(){
        return Arrays.toString(stackArray);
    }
}


