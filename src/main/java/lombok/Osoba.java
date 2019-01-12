package lombok;

@Setter
@Getter
@ToString(exclude = {"nazwisko"})
@EqualsAndHashCode

//adnotacja @Data laczy cztery powyzsze adnotacje

public class Osoba {

    private String imie;
    @EqualsAndHashCode.Exclude
    private String nazwisko;

}
