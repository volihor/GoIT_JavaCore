package mod_09_collections;
public class MyHashMap<K,V> implements InterfaceMyMap<K,V>  {

//    put(Object key, Object value);// додає пару ключ + значення
//    remove(Object key);// видаляє пару за ключем
//    clear();// очищає колекцію
//    size();// повертає розмір колекції
//    get(Object key);// повертає значення (Object value) за ключем

    private static final int DEFAULT_CAPACITY = 4; // Default initial capacity of arrayHashMap[] .
    private Node<K,V>[] arrNodes;
    private int size;

    public MyHashMap(){
        this(DEFAULT_CAPACITY );
    }
    public MyHashMap(int capacityHashMap){
        if(capacityHashMap < DEFAULT_CAPACITY){
            this.arrNodes = new Node[DEFAULT_CAPACITY];
        }
        this.arrNodes = new Node[capacityHashMap];
        this.size = 0;
    }

    private class Node<K,V> {
        private K key;
        private V value;
        private Node<K,V> next;
//        public K getKey() {
//            return key;
//        }
//        public V getValue() {
//            return value;
//        }
//        public void setValue(V value) {
//            this.value = value;
//        }

        public Node(K key, V value, Node<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        @Override
        public String toString(){
            return "Key: " + key + ",\tvalue: " + value;
        }
    }

    @Override
    public V put(K keyNew, V valueNew) {
        int hashInd = getHash(keyNew);
        Node<K,V> kvNode = arrNodes[hashInd];
        if(kvNode == null){             // first node
            arrNodes[hashInd] = new Node<>(keyNew, valueNew, null);
        }else{                          // cheking for matching key to change value
            while(kvNode.next != null){
                if( (kvNode.key) == keyNew){
                    kvNode.value = valueNew;
                    break;
                }
                kvNode = kvNode.next;
            }
            if( kvNode.next == null){
                kvNode.next =  new Node<>(keyNew, valueNew, null);
            }
        }
        System.out.println("Index: " + hashInd + "\tvalue: " + valueNew );

        size++;
        return valueNew;
    }

    @Override
    public V remove(K keyRemove) {
        if(size == 0){
        return null;
        }
        int hash = getHash(keyRemove);
        V val;
        Node<K,V> node;
            for (int i = 0; i < arrNodes.length; i++) {
            node = arrNodes[i];
            if (node == null) {
                continue;
            } else if (node.key == keyRemove) {
                val = node.value;
                node = null;                //  set reference arrNodes[i] to null
                size--;
                return val;
            } else {                        //  check LinkedList Node elements

                while ((node.next != null)) {
                    if (node.next.key == keyRemove) {
                        val = node.next.value;
                        node.next = null;        //  set reference to next Node to null
                        size--;
                        return val;
                    }
                    node = node.next;
                }                           // check the last Node elements
//                if (node.key == keyRemove) {
//                    node = null;            //  set reference arrNodes[i] to null
//                    return node.value;
//                }
            }
        }
    return null;
    }

    @Override
    public void clear() {
        arrNodes = new Node[arrNodes.length];
        size = 0;
    }

    @Override
    public V get(K keyFind) {
        if(size == 0){
            return null;
        }
        int hash = getHash(keyFind);
        Node<K,V> node;
        for (int i = 0; i < arrNodes.length; i++) {
            node = arrNodes[i];
            if (node == null) {
                continue;
            } else if (node.key == keyFind) {
                return node.value;
            } else {                        // check LinkedList Node elements
                while ((node.next != null)) {
                    if (node.key == keyFind) {
                        return node.value;
                    }
                    node = node.next;
                }                           // check the last Node elements
                if (node.key == keyFind) {
                    return node.value;
                }
            }
        }
        return null;
    }
//  private V checkKeys(Node<K,V> node, K keyFind){
//      if (node.key == keyFind){
//          return node.value;
//      }
//      return null;
//  }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private int getHash(K key){
        return key.hashCode() % arrNodes.length;
    }

    @Override
    public String toString(){
        if(size == 0)
            return "{ ---  empty  --- }";

        String print = "\n{ \n";
        for (int i = 0; i < arrNodes.length ; i++) {
            if( arrNodes[i] == null) continue;
            print += "  [Key: " + arrNodes[i].key + ",\tvalue: " + arrNodes[i].value + "]";
            for(Node<K,V> hasNext = arrNodes[i]; hasNext.next != null ; ){
                hasNext = hasNext.next;
                print += ",[Key: " + hasNext.key + ",\tvalue: " + hasNext.value + "]";
            }
            print += "\n";
        }
        return print + " }";
    }
}
