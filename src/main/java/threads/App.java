package threads;

public class App {

    public static void main(String[] args) {

        //Wyswietla nazwe biezacego watku
        System.out.println(Thread.currentThread().getName());

        //Tworzy nowy watek dla klasy, ktora implementuje interfejs Runnable

        Thread thread = new Thread(new Async());
        thread.start();

        //Tworzy nowy watek dla klasy, ktora dziedziczy po klasie Thread

        Thread thread2 = new Async2();
        thread2.start();


    }

    private static class Async implements Runnable {

        @Override
        public void run() {
            System.out.println("Moj nowy watek: " + Thread.currentThread().getName());
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello World from my super hero thread");
            }
        }
    }

    private static class Async2 extends Thread {
        public void run() {
            System.out.println("Moj nowy watek 2: " + Thread.currentThread().getName());
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello World from my super hero thread 2");
            }
        }
    }

}
