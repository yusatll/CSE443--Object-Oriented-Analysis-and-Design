package hw2;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HiTech hi = new HiTech();
        TrafficLight trafficLight = new TrafficLight(hi,100);

        hi.changeDetected(false);
        System.out.println("\nMOBESE traffic detected.");
        hi.changeDetected(true);
    }
}
