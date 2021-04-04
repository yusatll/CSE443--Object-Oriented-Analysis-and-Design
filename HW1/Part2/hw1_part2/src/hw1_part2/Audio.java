package hw1_part2;

import java.util.ArrayList;

public class Audio implements Subject{
    ArrayList<Observer> subscribers;
    private String audio_name;

    /**
     * Constructor
     */
    Audio()
    {
        subscribers = new ArrayList<>();
        audio_name = "Welcome To Audio Page";
    }

    /**
     * An observer register to Audio Subscriber
     * @param obs Observer to register
     */
    @Override
    public void registerObserver(Observer obs) {
        System.out.println("An observer registered to Audio Subscribers");
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
            System.out.println("A Subscriber left from Audio.");
            subscribers.remove(index);
        }
    }

    /**
     * Notify all our subscribers
     */
    @Override
    public void notifyToObservers() {
        System.out.println("Audio Subscribers Notified.");
        for (Observer obs:subscribers) {
            obs.update(audio_name);
        }
    }

    /**
     * Change the audio name.
     * @param msg It's news.
     */
    @Override
    public void changeStringMessage(String msg) {
        System.out.println("Audio name chanced with " + msg);
        this.audio_name = msg;
    }
}
