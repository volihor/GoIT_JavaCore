package mod_09_collections;

public class MyLinkedList<E> implements InterfaceMyList<E> {
//     LinkedList
//    add(Object value) //додає елемент в кінець
//    remove(int index) //видаляє елемент із вказаним індексом
//    clear() //очищає колекцію
//    size() //повертає розмір колекції
//    get(int index) //повертає елемент за індексом

    private int size =0;
    private Node<E> head;   // Pointer to first node.
    private Node<E> tail;   // Pointer to last node.

    public MyLinkedList(){
    }

    private static class Node<E> {
        E item;
        MyLinkedList.Node<E> prev;
        MyLinkedList.Node<E> next;
        public Node(MyLinkedList.Node<E> prev, E item, MyLinkedList.Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }



    @Override
    public boolean add(E e) {
        if(head == null){
            addNodeToHead(e);
        }else{
            addNodeToTail(e);
        }
        size++;
        return true;
    }
    private void addNodeToHead(E e){
        final Node<E> next = head;
        final Node<E> newNode = new Node<>(null, e, next);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            head.prev = newNode;
            head = newNode;
        }
    }
    private void addNodeToTail(E e){
        final Node<E> prev = tail;
        final Node<E> newNode = new Node<>(prev, e, null);
        tail.next = newNode;
        tail = newNode;
    }



    @Override
    public E remove(int index) {
        Node<E> nodeToRemove = findNode(index);
        E e = nodeToRemove.item;
        removeNode(nodeToRemove);
        size--;
        return e;
    }
    private Node<E> findNode(int index){
        Node<E> eNode;
        if(index <= size/2 ){
            eNode = head;
            for (int i = 0; i < index ; i++) {
                eNode = eNode.next;
            }
        }else{
            eNode = tail;
            for (int i = size-1 ; i > index ; i--) {
                eNode = eNode.prev;
            }
        }
        return eNode ;
    }
    private boolean removeNode(Node<E> nodeToRemove){
        Node<E> prev = nodeToRemove.prev;
        Node<E> next = nodeToRemove.next;
        // To remove the 'first' node changing 'head' pointer.
        if(prev == null){
            next.prev = null;
            head = next;
        // To remove the 'last' node changing 'tail' pointer.
        }else if(next == null){
            prev.next = null;
            tail = prev;
        }else{
            prev.next = next;
            next.prev = prev;
        }
        nodeToRemove.prev = null;
        nodeToRemove.next = null;
        return true;
    }

    /*
    *  form interface InterfaceMyCollection.
    *  Not implemented
    * */
    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {
        for (Node<E> i = head; i != null;) {
            Node<E> next = i.next;
            i.item = null;
            i.prev = null;
            i.next = null;
            i = next;
        }
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }
    // Returns the element at the specified position in this list.
    @Override
    public E get(int index) {
        return findNode(index).item;
    }


    @Override
    public String toString(){
        if(head == null){
            return "Linked list is empty !";
        }
        Node<E> eNode = head;
        String s = "";
        for (Node<E> i = eNode; ; ) {
            s += "[" + i.item + "]";
            if(i.next != null){
                s += "=";
            }
            if(i.next == null){
                return s;
            }
            i = i.next;
        }
    }
}
