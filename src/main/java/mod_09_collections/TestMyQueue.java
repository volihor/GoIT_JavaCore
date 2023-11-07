package mod_09_collections;

public class TestMyQueue {
    public static void main(String[] args) {
        InterfaceMyQueue<Integer> intQueue = new MyQueue<>();
        InterfaceMyQueue<String> strQueue = new MyQueue<>();

        intQueue.add(0);
        intQueue.add(1);
        intQueue.add(2);
        intQueue.add(3);

        strQueue.add("Andriy");
        strQueue.add("Bohdan");
        strQueue.add("Casey");

        System.out.println("intQueue : " + intQueue);
        System.out.println("strQueue : " + strQueue);

        System.out.println("\n intQueue.size() = " + intQueue.size());
        System.out.println(" strQueue.size() = " + strQueue.size() + "\n");

        // Queue is full !!!  Element : <E> is NOT added.
        System.out.println(" Adding next values :  4 "
                        + "\n   intQueue.add(4);");
                intQueue.add(4);

        System.out.println("\n intQueue.peek() = " + intQueue.peek());
        System.out.println(" strQueue.peek() = " + strQueue.peek());

        System.out.println("\n intQueue.poll() = " + intQueue.poll());
        System.out.println(" intQueue.size() = " + intQueue.size());
        System.out.println("intQueue : " + intQueue);

        System.out.println("\n Adding next values :  4 and 5"
                            + "\n   intQueue.add(4);"
                            + "\n   intQueue.add(5);");
        intQueue.add(4);
        intQueue.add(5);
        System.out.println("intQueue : " + intQueue);
        System.out.println(" intQueue.size() = " + intQueue.size());

        intQueue.clear();
        intQueue.add(10);
        intQueue.add(11);
        System.out.println("\n Clearing intQueue and adding <10> <11>) : " + intQueue);
        System.out.println(" intQueue.size() = " + intQueue.size());


        System.out.println("\n intQueue.poll() = " + intQueue.poll());
        System.out.println(" intQueue.poll() = " + intQueue.poll());
        System.out.println(" intQueue.size() = " + intQueue.size());
        System.out.println(" after two pooling should be empty : " + intQueue);




        strQueue.clear();
        System.out.println("\n after CLEAR strQueue.clear() = " + strQueue);
        System.out.println(" strQueue.size() = " + strQueue.size());
        System.out.println(" When Queue isEmpty strQueue.peek() = " + strQueue.peek());


    }
}
