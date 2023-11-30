package mod_12_Multithreading;

import java.sql.Date;
import java.sql.Time;
import java.time.Clock;

public class OneFiveSecondThreads {
    public static void main(String[] args) {
        TimeCounter timeCounter_1 = new TimeCounter();
        TimeCounter timeCounter_5 = new TimeCounter(5);

        timeCounter_1.start();
        timeCounter_5.start();
    }
}
class TimeCounter extends Thread{
    private int counterSecond;
    private final int COUNTER_DEFAULT = 1;
    public TimeCounter(){
        this.counterSecond = COUNTER_DEFAULT;
    }
    public TimeCounter(int counterSecond){
        this.counterSecond = counterSecond;
    }

     Clock clock = Clock.systemDefaultZone();

    @Override
    public void run() {
        Long startTime = clock.millis();
        while(true){
            try {
                sleep( (counterSecond * 1000) );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Long endTime = clock.millis();
            if (this.counterSecond == 1)
                System.out.println("Past " + (endTime-startTime)/1000 + " seconds.");
            else
                System.out.println("*** Past " + (endTime-startTime)/1000 + " seconds.");
        }
    }
}
