package mod_11_StreamAPI;

import java.util.LinkedList;
import java.util.stream.Stream;

public class LinearCongruentialGenerator {
    public static void main(String[] args) {

        LinearCongruentialGenerator lcg = new LinearCongruentialGenerator();

        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);
        long seed = 12345L;
        int count = 8;  // Number of elements in the stream

        Stream<Long> linearCongrGen = lcg.linCongrGen(a, c, m, seed, count);
        linearCongrGen.forEach(System.out::println);
    }

    public Stream<Long> linCongrGen(long a, long c, long m, long seed, int count){
        return Stream.iterate(seed, x-> (a * x + c) % m )
                             .limit(count);
    }
}
