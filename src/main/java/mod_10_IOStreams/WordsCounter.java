package mod_10_IOStreams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class WordsCounter {

    public static void main(String[] args) {

        String countWords = "";
  // read from words.txt file to string countWords
        try {
            FileReader fr = new FileReader("src/main/java/mod_10_IOStreams/words.txt");
            Scanner sc = new Scanner(fr);
            String strWords = "";

            while (sc.hasNext()){
                strWords += " " + sc.nextLine();
            }
            countWords = strWords.trim();
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // save unique world to the HashMap<String, Integer> from ArrayList<String> listWords
        // with value as the number of counted words
        ArrayList<String> listWords = new ArrayList<>( Arrays.asList(countWords.split(" ")) );
        HashMap<String, Integer> wordCountsMap = new HashMap<>();
        //        System.out.println("listWords = " + listWords);
        for(String string : listWords){
            wordCountsMap.put( string,
                    (wordCountsMap.containsKey(string) ? wordCountsMap.get(string)+1 : 1 )
            );
        }
        //        wordCountsMap.entrySet().stream()
        //                .forEach(System.out::println);


// ----------------------------------------------------------------------------
//  1-st realisation of WorldCounter reversed order
    // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(wordCountsMap.entrySet());

  // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> m1,
                               Map.Entry<String, Integer> m2)
            {
            //  reversed order
                return (m2.getValue()).compareTo(m1.getValue());
            }
        });

  // put data from sorted list to hashmap
        HashMap<String, Integer> sortedWordCountsMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> map : list) {
            sortedWordCountsMap.put(map.getKey(), map.getValue());
        }

  //        sortedWordCountsMap.entrySet().forEach(System.out::println);
        for(String key: sortedWordCountsMap.keySet()){
            System.out.println(key + " " + wordCountsMap.get(key));
        }


// ----------------------------------------------------------------------------
//  2-d realisation of WorldCounter reversed order (Stream API)
//        HashMap<String, Integer> sortedWordCountsMap = wordCountsMap.entrySet().stream()
        sortedWordCountsMap = wordCountsMap.entrySet().stream()
                //  reversed order
                .sorted((es1, es2) -> es2.getValue().compareTo(es1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey
                       ,Map.Entry::getValue
                       ,(oldValue, newValue) -> oldValue
                       ,LinkedHashMap::new)
                );

        System.out.println("--- with stream ---");
        for(String key: sortedWordCountsMap.keySet()){
            System.out.println(key + " " + wordCountsMap.get(key));
        }

    }
}
