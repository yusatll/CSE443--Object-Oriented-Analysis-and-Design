package hw1_part2;

import java.util.ArrayList;

public class Text implements Subject {

    ArrayList<Observer> subscribers;
    private String text_name;

    /**
     * Constructor
     */
    Text()
    {
        subscribers = new ArrayList<>();
        text_name = "Welcome To Text Page";
    }

    /**
     * An observer register to Text Subscriber
     * @param obs Observer to register
     */
    @Override
    public void registerObserver(Observer obs) {
        System.out.println("An observer registered to Text Subscribers");
        subscribers.add(obs);
    }

    /**
     * Delete a subscriber from our subscriber list.
     * @param obs Observer remove
     */
    @Override
    public void deleteObserver(Observer obs) {
        int index = subscribers.indexOf(obs);
        if (index >= 0) {
            System.out.println("A Subscriber left from Text Page.");
            subscribers.remove(index);
        }
    }

    /**
     * Notify all our subscribers
     */
    @Override
    public void notifyToObservers() {
        System.out.println("Text Subscribers Notified.");
        for (Observer obs:subscribers) {
            obs.update(text_name);
        }
    }

    /**
     * Change the audio name.
     * @param msg It's news.
     */
    @Override
    public void changeStringMessage(String msg) {
        System.out.println("Audio name chanced with " + msg);
        this.text_name = msg;
    }
}
