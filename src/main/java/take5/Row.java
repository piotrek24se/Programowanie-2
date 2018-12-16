package take5;

public class Row {

    private String winning_numbers;


    public String getWinning_numbers() {
        return winning_numbers;
    }

    public void setWinning_numbers(String winning_numbers) {
        this.winning_numbers = winning_numbers;
    }

    @Override
    public String toString() {
        return "Row{" +
                "winning_numbers=" + winning_numbers +
                '}';
    }
}
