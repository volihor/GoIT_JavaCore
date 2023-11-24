package mod_11_StreamAPI;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class OddIndexesNames {
    public static void main(String[] args) {

        String path = "src/main/java/mod_11_StreamAPI/names.txt";
        List<String> arrListOfNames = readFromTextToArrayList(path);
        List<String> oddIndexedNames = getOddIndexedStrings(arrListOfNames);
        oddIndexedNames.forEach(System.out::print);
    }

    static List<String> getOddIndexedStrings(List<String> arrListOfNames) {
        return IntStream
                .range(0, arrListOfNames.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> i + ". " + arrListOfNames.get(i) + ",  ")
                .collect(Collectors.toList());
    }

    static List<String> readFromTextToArrayList(String pathIn) {
        String stringToArray = "";
        try (FileReader fileReader = new FileReader(pathIn)){
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
}
