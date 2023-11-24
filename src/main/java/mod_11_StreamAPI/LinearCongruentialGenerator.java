package mod_11_StreamAPI;

import java.util.stream.Stream;

public class LinearCongruentialGenerator {
    public static void main(String[] args) {

        LinearCongruentialGenerator lcg = new LinearCongruentialGenerator();

        long seed = 12345L;               // The initial value of sequence {@code seed}
                                            // The first element (position {@code 0}) in the {@code Stream} will be
                                            //     * the provided {@code seed}
        long a = 25214903917L;            // The multiplier
        long c = 11L;                     // The increment
        long m = (long) Math.pow(2, 48);  // The modulus


        Stream<Long> linearCongrGen = lcg.linCongrGen(seed, a, c, m);
        linearCongrGen.forEach(System.out::println);
    }

    // !!! WARNING !!! Create infinite loop of  Linear Congruential Generator
    public Stream<Long> linCongrGen(long seed, long a, long c, long m){
        return Stream.iterate(seed, x-> (a * x + c) % m );     //  Stream.iterate( x[0]=seed, x(n)= f(n-1) )
//        .limit(10);  // MaxSize 10
    }
}
