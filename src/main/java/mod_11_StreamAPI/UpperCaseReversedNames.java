package mod_11_StreamAPI;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseReversedNames {
    public static void main(String[] args) {

        String path = "src/main/java/mod_11_StreamAPI/names.txt";
        List<String> listNames =  new OddIndexesNames().readFromTextToArrayList(path);
//       listNames.forEach(System.out::println);
        List<String> collect = listNames.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}
