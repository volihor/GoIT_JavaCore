package mod_09_collections;

public class TestMyArrayList {
    public static void main(String[] args) {
        InterfaceMyList<Integer> intArrayList = new MyArrayList<>(5);
        InterfaceMyList <String> strArrayList = new MyArrayList<>(5);

        intArrayList.add(0);
        intArrayList.add(1);
        intArrayList.add(2);
        intArrayList.add(3);

        strArrayList.add("10");
        strArrayList.add("string");

        System.out.println("before remove intArrayList = " + intArrayList);
        System.out.println("before remove strArrayList = " + strArrayList);

        intArrayList.remove(1);
        strArrayList.remove(0);

        System.out.println("  after remove intArrayList = " + intArrayList);
        System.out.println("  after remove strArrayList = " + strArrayList);

        strArrayList.clear();

        System.out.println("    after clear() strArrayList = " + strArrayList);

        System.out.println("\nintArrayList.size() = " + intArrayList.size());
        System.out.println("  after remove intArrayList = " + intArrayList);
        intArrayList.remove(intArrayList.size());
        System.out.println("  -- Remove ---\n after intArrayList.remove(3): " + intArrayList);
        System.out.println("intArrayList.size() = " + intArrayList.size());
        System.out.println("strArrayList.size() = " + strArrayList.size());

        intArrayList.add(4);
        intArrayList.add(5);
        intArrayList.add(6);
        intArrayList.add(7);

        System.out.println("  after add() 4 alaments to intArrayList = " + intArrayList);
        System.out.println("  intArrayList.size() + 4 alaments = " + intArrayList.size());

        intArrayList.clear();
        System.out.println("    after clear() intArrayList = " + intArrayList);

    }
}
