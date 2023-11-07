package mod_09_collections;

public class TestLinkedList{
    public static void main(String[] args) {
        InterfaceMyList<Integer> intLinkedList = new MyLinkedList<>();
        InterfaceMyList<String> strLinkedList = new MyLinkedList<>();

        // ADD
        intLinkedList.add(0);
        intLinkedList.add(1);
        intLinkedList.add(2);
        intLinkedList.add(3);

        strLinkedList.add("10");
        strLinkedList.add("string");

        System.out.println("intLinkedList : " + intLinkedList);
        System.out.println("strLinkedList : " + strLinkedList);

        //  SIZE
        System.out.println("intLinkedList.size() = " + intLinkedList.size());
        System.out.println("strLinkedList.size() = " + strLinkedList.size() + "\n");

        //  CLEAR
        strLinkedList.clear();
//
        System.out.println("   after clear() strLinkedList : " + strLinkedList);
//
        System.out.println("   strLinkedList.size() = " + strLinkedList.size() + "\n");
//
        intLinkedList.add(4);
        intLinkedList.add(5);
        intLinkedList.add(6);
        intLinkedList.add(7);

        System.out.println("intLinkedList : " + intLinkedList);


        System.out.println(" intLinkedList.size() = " + intLinkedList.size());
        int index = 7;

        // REMOVE (int index)
        Integer integer = intLinkedList.remove(index);
        System.out.println("Index to remove : " + integer);
//        strLinkedList.remove(0);
//
        System.out.println(" after remove( "+ integer +" )  intLinkedList = " + intLinkedList);
        System.out.println("   after intLinkedList.size() = " + intLinkedList.size());

        index = 1;
        integer = intLinkedList.remove(index);
        System.out.println("Index to remove : " + integer);
//        strLinkedList.remove(0);
//
        System.out.println(" after remove( "+ integer +" )  intLinkedList = " + intLinkedList);
        System.out.println("   after intLinkedList.size() = " + intLinkedList.size());
//        System.out.println("  after remove strLinkedList = " + strLinkedList);

        // GET(int index)
        System.out.println("\n intLinkedList.get(4) = " + intLinkedList.get(4));
//
//        System.out.println("  after add() 4 alaments to intLinkedList = " + intLinkedList);
//        System.out.println("  intLinkedList.size() + 4 alaments = " + intLinkedList.size());
//
//        intLinkedList.clear();
//        System.out.println("    after clear() intLinkedList = " + intLinkedList);

    }
}
