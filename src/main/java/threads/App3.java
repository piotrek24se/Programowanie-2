package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class App3 {

    private static AtomicInteger sum = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(2);

        es.execute(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                sum.incrementAndGet();
            }
        });

        es.execute(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                sum.decrementAndGet();
            }
        });

        //zamykanie puli
        es.shutdown();

        //odpowiednik bezpiecznika - oczekiwanie maks. 10 min na zakonczenie pracy watkow
        es.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println(sum);

    }

}
