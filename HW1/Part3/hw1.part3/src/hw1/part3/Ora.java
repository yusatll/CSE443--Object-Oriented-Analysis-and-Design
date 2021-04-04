package hw1.part3;

public class Ora extends Suit{

    Ora()
    {
        this.suit_type = "Ora: ";
    }

    /**
     * Suit class's metod overrided.
     * @return Ora's Cost
     */
    @Override
    public double cost() {
        return 1500.0;
    }

    /**
     * Suit class's metod overrided.
     * @return Ora's Weight
     */
    @Override
    public double weight() {
        return 30.0;
    }
}
