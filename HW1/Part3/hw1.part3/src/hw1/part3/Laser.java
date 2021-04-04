package hw1.part3;

public class Laser extends Accessories {

    private Suit s;

    Laser(Suit suit)
    {
        this.s = suit;
    }


    @Override
    public double cost() {
        return s.cost() + 200.0;
    }

    @Override
    public double weight() {
        return s.weight() + 5.5;
    }

    @Override
    public String getSuit_type() {
        return s.getSuit_type() + " + Laser ";
    }
}
