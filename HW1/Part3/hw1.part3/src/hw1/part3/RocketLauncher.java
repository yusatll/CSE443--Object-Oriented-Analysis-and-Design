package hw1.part3;

public class RocketLauncher extends Accessories {

    private Suit s;

    RocketLauncher(Suit suit)
    {
        this.s = suit;
    }

    @Override
    public double cost() {
        return s.cost() + 150.0;
    }

    @Override
    public double weight() {
        return s.weight() + 7.5;
    }

    @Override
    public String getSuit_type() {
        return s.getSuit_type() + " + Rocket Launcher ";
    }
}
