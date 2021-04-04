package hw1.part3;

public class AutoRifle extends Accessories {

    private Suit s;

    AutoRifle(Suit suit)
    {
        this.s = suit;
    }

    /**
     * get suit cost and add my cost
     * @return total cost
     */
    @Override
    public double cost() {
        return s.cost() + 30.0;
    }

    /**
     * get weight from suit and add my weight
     * @return total weight
     */
    @Override
    public double weight() {
        return s.weight() + 1.5;
    }

    /**
     * Get Suit type from Suit and add my suit type
     * @return String
     */
    @Override
    public String getSuit_type() {
        return s.getSuit_type() + " + AutoRifle ";
    }
}
