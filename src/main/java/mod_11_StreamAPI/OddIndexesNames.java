package mod_11_StreamAPI;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class OddIndexesNames {
    public static void main(String[] args) {

        OddIndexesNames oin = new OddIndexesNames();
        String path = "src/main/java/mod_11_StreamAPI/names.txt";
        //  get ArrayList<String> from the file
        List<String> arrListOfNames = oin.readFromTextToArrayList(path);
        //  Print all names, vertical
        arrListOfNames.forEach(System.out::println);
        //  get changed ArrayList<String> with odds indexes
        List<String> oddIndexedNames = oin.getOddIndexedStrings(arrListOfNames);
        //  Print all odd Indexed Names
        oddIndexedNames.forEach(System.out::print);
    }

    List<String> readFromTextToArrayList(String pathIn) {
        String stringToArray = "";
        try {
            FileReader fileReader = new FileReader(pathIn);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()){
                stringToArray = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  Arrays.asList(stringToArray.split(" "));
    }

    List<String> getOddIndexedStrings(List<String> arrListOfNames) {
        return IntStream
                .range(0, arrListOfNames.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> i + ". " + arrListOfNames.get(i) + ",  ")
                .collect(Collectors.toList());
    }
}
