package hw1.part3;

public class Tor extends Suit {

    Tor()
    {
        this.suit_type = "Tor: ";
    }

    /**
     * Suit class's metod overrided.
     * @return Tor's Cost
     */
    @Override
    public double cost() {
        return 5000.0;
    }

    /**
     * Suit class's metod overrided.
     * @return Tor's Weight
     */
    @Override
    public double weight() {
        return 50.0;
    }
}
