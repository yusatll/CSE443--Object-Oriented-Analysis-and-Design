package hw1.part3;

public class Flamethrower extends Accessories{

    private Suit s;

    Flamethrower(Suit suit)
    {
        this.s = suit;
    }

    @Override
    public double cost() {
        return s.cost() + 50.0;
    }

    @Override
    public double weight() {
        return s.weight() + 2.0;
    }

    @Override
    public String getSuit_type() {
        return s.getSuit_type() + " + Flamethrower ";
    }
}
