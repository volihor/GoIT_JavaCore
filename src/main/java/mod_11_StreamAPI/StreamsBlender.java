package mod_11_StreamAPI;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsBlender {
    public static void main(String[] args) {
        Collection<String> firstNames = Arrays.asList("1_Abby", "2_Bianca", "3_Cameron", "4_Dayan", "Elliot", "Fatima", "Gabriella", "8_Harley");
        Collection<String> familyNames = Arrays.asList("Filder_1", "Gogiashvilly_2", "Amideal_3", "Bandini_4");

        zipC(firstNames.stream(), familyNames.stream())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("--------------------");
    }

//    combines two Streams in mixed ways until the in one of them have no elements
    public static <T> Stream<T> zipC(Stream<T> first, Stream<T> second){
        List<T> collectFirst = first.collect(Collectors.toList());
        List<T> collectSecond = second.collect(Collectors.toList());

        int sizeF = collectFirst.size();
        int sizeS = collectSecond.size();
        int minLength = Math.min(sizeF, sizeS);

       return IntStream
               //  IntStream.range to iterate over the indexes of the shorter list
               .range(0, minLength)
               //  For each index creates a new stream containing the corresponding elements from both lists.
               //  mapToObj maps every index to a stream of two list elements, one from each list given
               .mapToObj((i -> Stream.of(collectFirst.get(i), collectSecond.get(i))))
               //  Flattens these streams into a single stream using flatMap.
               .flatMap(s->s);
    }
}
