package mod_09_collections;

import java.util.Queue;

public class MyQueue<E> implements InterfaceMyQeueI<E> {
    //  FIFO (first-in-first-out).
//    new Queue
//    add(Object value);//
//    clear();
//    size();
//    peek();
//    poll();
    @Override //додає елемент в кінець
    public boolean add(E e) {
        return false;
    }
    @Override
    public boolean remove(Object o) {
        return false;
    }
    @Override // очищає колекцію
    public void clear() {

    }
    @Override // повертає розмір колекції
    public int size() {
        return 0;
    }
    @Override // повертає перший елемент з черги
    public E peek() {
        return null;
    }
    @Override // повертає перший елемент з черги і видаляє його з колекції
    public E poll() {
        return null;
    }
}
