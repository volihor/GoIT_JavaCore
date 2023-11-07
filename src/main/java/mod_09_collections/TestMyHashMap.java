package mod_09_collections;

public class TestMyHashMap {
    public static void main(String[] args) {
        InterfaceMyMap<String, Integer> firstHashMap = new MyHashMap<>();

        System.out.println("\n  ---  PUT  ---   ");
        firstHashMap.put("Andriy", 12);
        firstHashMap.put("Bohdan", 23);
        firstHashMap.put("Casey" , 34);
        firstHashMap.put("Diane" , 45);
        firstHashMap.put("Emmy"  , 56);
        firstHashMap.put("Fabio" , 67);
        firstHashMap.put("Gustav", 78);
        firstHashMap.put("Helga" , 89);
        firstHashMap.put("Jacob" , 99);

        System.out.println("firstHashMap.size() = " + firstHashMap.size());

        System.out.println(firstHashMap);

        System.out.println("\n  ---  GET  ---   ");
        System.out.println("get(\"Gustav\")  = " + firstHashMap.get("Gustav"));
        System.out.println("get(\"Fabio\")   = " + firstHashMap.get("Fabio"));
        System.out.println("get(\"Jacob\")   = " + firstHashMap.get("Jacob"));
        System.out.println("get(\"nothing\") = " + firstHashMap.get("nothing"));
        System.out.println("firstHashMap.size() = " + firstHashMap.size());


        System.out.println("\n  ---  REMOVE  ---   ");
        System.out.println("remove(\"Jacob\"),  value: " + firstHashMap.remove("Jacob"));
        System.out.println("remove(\"Fabio\"),  value: " + firstHashMap.remove("Fabio"));
        System.out.println("remove(\"Bohdan\"), value: " + firstHashMap.remove("Bohdan"));
        System.out.println(firstHashMap);
        System.out.println("firstHashMap.size() = " + firstHashMap.size());


        System.out.println("\n  ---  CLEAR  ---   ");
        firstHashMap.clear();
        System.out.println(firstHashMap);

    }
}
