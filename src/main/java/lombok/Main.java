package lombok;

public class Main {

    public static void main(String[] args) {

        //mamy dostep do getterow i setterow za posrednictwem lombok
        //bez wstepnego zainstalowania pluginu, ponizsze settery swiecilyby sie na czerwono

        Osoba osoba = new Osoba();
        osoba.setImie("Ala");
        osoba.setNazwisko("Nowak");
        System.out.println(osoba);

    }
}
