package hw1.part3;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Suit s1 = new Ora();
        System.out.println(s1.getSuit_type() + " = " + s1.cost() + " k TL " + s1.weight() + " kg.");
        System.out.println();

        Suit s2 = new Dec();
        s2 = new Flamethrower(s2);
        s2 = new RocketLauncher(s2);
        s2 = new Laser(s2);
        System.out.println(s2.getSuit_type() + " = " + s2.cost() + " k TL " + s2.weight() + "kg.");
        System.out.println();

        Suit s3 = new Tor();
        System.out.println(s3.getSuit_type() + " = " + s3.cost() + " k TL " + s3.weight() + "kg.");
        s3 = new Laser(s3);
        System.out.println(s3.getSuit_type() + " = " + s3.cost() + " k TL " + s3.weight() + "kg.");
        s3 = new AutoRifle(s3);
        System.out.println(s3.getSuit_type() + " = " + s3.cost() + " k TL " + s3.weight() + "kg.");
        s3 = new RocketLauncher(s3);
        System.out.println(s3.getSuit_type() + " = " + s3.cost() + " k TL " + s3.weight() + "kg.");
    }
}
