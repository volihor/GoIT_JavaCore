package mod_12_Multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class FizzBuss {
    private int toNumber;
    private int currentNumber = 1;
    private final Object MONITOR = new Object();
    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
//    private static final List<String> queue = new LinkedList<>();

    public FizzBuss(int n) {
        this.toNumber = n;
    }

    public void fizz() throws InterruptedException {
        synchronized (MONITOR) {
            while (currentNumber <= toNumber) {
                if (currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                    queue.add("Fizz");
                    currentNumber++;
                    MONITOR.notifyAll();
                } else {
                    MONITOR.wait();
                }
            }
        }
    }

    public void buzz() throws InterruptedException {
        synchronized (MONITOR) {
            while (currentNumber <= toNumber) {
                if (currentNumber % 5 == 0 && currentNumber % 3 != 0) {
                    queue.add("Buzz");
                    currentNumber++;
                    MONITOR.notifyAll();
                } else {
                    MONITOR.wait();
                }
            }
        }
    }

    public void fizzbuzz() throws InterruptedException {
        synchronized (MONITOR) {
            while (currentNumber <= toNumber) {
                if (currentNumber % 15 == 0) {
                    queue.add("FizzBuzz");
                    currentNumber++;
                    MONITOR.notifyAll();
                } else {
                    MONITOR.wait();
                }
            }
        }
    }

    public void number() throws InterruptedException {
        synchronized (MONITOR) {
            while (currentNumber <= toNumber) {
                if (currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                    queue.add(Integer.toString(currentNumber));
                    currentNumber++;
                    MONITOR.notifyAll();
                } else {
                    MONITOR.wait();
                }
            }
        }
//        for (String s: queue){
//            System.out.print(s + ", ");
//        }
        System.out.println(
                queue.stream()
                .collect(Collectors.joining(", ", "", ""))
        );

    }





    public static void main(String[] args) {
        FizzBuss fizzBuzz = new FizzBuss(15);

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }
}
