package mod_11_StreamAPI;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayOfStringNumbers {
    public static void main(String[] args) {
        String[] arrString = {"1, 2, 0", "4, 5"};
        String streamStringCollect = Arrays.stream(arrString)
                .flatMap(s -> Arrays.stream(s.split(",\\s*")))
                .sorted()
                .collect(Collectors.joining(",", "\"", "\""));

        Stream.of(streamStringCollect).forEach(System.out::println);
//        System.out.println(streamStringCollect);

    }
}
