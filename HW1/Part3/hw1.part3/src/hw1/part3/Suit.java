package hw1.part3;

public abstract class Suit {
    protected String suit_type = "Type";

    public abstract double cost();

    public abstract double weight();

    public String getSuit_type(){
        return this.suit_type;
    }
}
