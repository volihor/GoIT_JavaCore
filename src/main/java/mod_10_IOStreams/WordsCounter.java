package mod_10_IOStreams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsCounter {

    public static void main(String[] args) {
        String countWords = "";
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

        List<String> listWords = Arrays.asList(countWords);
        Map<String, Integer> wordCounts = Stream.of(listWords)
                .flatMap(Collection::stream)
                .flatMap(str -> Arrays.stream(str.split(" ")))
                .collect(Collectors.toMap(
                        String::toLowerCase,
                        i -> 1,
                        Integer::sum)
                );

        System.out.println(wordCounts);
        for(String key: wordCounts.keySet()){
            System.out.println(key + " " + wordCounts.get(key));
        }


    }
}
