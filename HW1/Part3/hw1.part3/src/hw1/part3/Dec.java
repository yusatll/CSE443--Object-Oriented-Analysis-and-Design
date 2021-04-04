package hw1.part3;

public class Dec extends Suit{

    Dec()
    {
        this.suit_type = "Dec: ";
    }

    /**
     * Suit class's metod overrided.
     * @return Dec's Cost
     */
    @Override
    public double cost() {
        return 500.0;
    }

    /**
     * Suit class's metod overrided.
     * @return Dec's Weight
     */
    @Override
    public double weight() {
        return 25.0;
    }
}
