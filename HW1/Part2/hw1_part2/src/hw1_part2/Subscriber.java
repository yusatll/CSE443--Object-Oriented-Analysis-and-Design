package hw1_part2;

public class Subscriber implements Observer {
    private String subs_msg;

    @Override
    public void update(String msg) {
        this.subs_msg = msg;
        System.out.println("Subscriber updated: " + this.subs_msg);
    }
}
