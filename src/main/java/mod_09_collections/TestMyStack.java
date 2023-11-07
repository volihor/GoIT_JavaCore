package mod_09_collections;

public class TestMyStack {
    public static void main(String[] args) {
        InterfaceMyStack<Integer> intStack = new MyStack<>();
        InterfaceMyStack<String>  strStack = new MyStack<>();

        intStack.push(0);
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        strStack.push("Andriy");
        strStack.push("Bohdan");
        strStack.push("Casey");

        System.out.println("intStack : " + intStack);
        System.out.println("strStack : " + strStack);

        System.out.println("\n intStack.size() = " + intStack.size());
        System.out.println(" strStack.size() = " + strStack.size() + "\n");

        // Stack is full !!!  Element : <E> is NOT pushed.
        System.out.println(" Adding next values :  4 "
                + "\n   intStack.push(4);");
        intStack.push(4);

        System.out.println("\n intStack.peek() = " + intStack.peek());
        System.out.println(" strStack.peek() = " + strStack.peek());

        System.out.println("\n Before POP size() = " + intStack.size());
        System.out.println(" TOP value pop() = " + intStack.pop());
        System.out.println(" After  POP size() = " + intStack.size());
        System.out.println("intStack : " + intStack);

        System.out.println("\n Adding next values :  4 and 5"
                + "\n   intStack.push(4);"
                + "\n   intStack.push(5);");
        intStack.push(4);
        intStack.push(5);
        System.out.println("  After  PUSH size() = " + intStack.size());
        System.out.println("intStack : " + intStack);

        System.out.println("\n  ***  REMOVE(index) ***   intQueue");
        System.out.println(" intQueue.remove() = " + intStack.remove(2));
        System.out.println(" intStack : " + intStack);


        System.out.println("\n  ***  CLEAR  ***   intQueue");
        intStack.clear();
        intStack.push(10);
        intStack.push(11);
        System.out.println("Clearing intQueue and push <10> <11>) : " + intStack);
        System.out.println(" intQueue.size() = " + intStack.size());


        System.out.println("\n intQueue.pop() = " + intStack.pop());
        System.out.println(" intQueue.pop() = " + intStack.pop());
        System.out.println(" intQueue.size() = " + intStack.size());
        System.out.println(" After two pooling should be empty : " + intStack);




        strStack.clear();
        System.out.println("\n after CLEAR strStack.clear() = " + strStack);
        System.out.println(" strStack.size() = " + strStack.size());
        System.out.println(" When Queue isEmpty strStack.peek() = " + strStack.peek());


    }
}
