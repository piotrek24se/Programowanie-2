package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App2 {

    public static void main(String[] args) {

        //Nowszy sposobb tworzenia watkow (od Javy 8)

        //Wyswietla nazwe biezacego watku
        System.out.println(Thread.currentThread().getName());

        //Okreslenie liczby watkow, z ktorych chcemy korzystac
        ExecutorService es = Executors.newFixedThreadPool(1);

        es.execute(() -> {
            System.out.println("Moj nowy watek: " + Thread.currentThread().getName());
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello World from my super hero thread");
            }
        });

        //zamkniecie puli watkow
        es.shutdown();





    }

}
