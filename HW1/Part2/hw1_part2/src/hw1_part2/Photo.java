package hw1_part2;

import java.util.ArrayList;

public class Photo implements Subject{

    ArrayList<Observer> subscriber;
    private String photo_name;

    Photo()
    {
        subscriber = new ArrayList<>();
        photo_name = "Welcome to Photo Albums";
    }

    @Override
    public void registerObserver(Observer obs) {
        System.out.println("An observer registered to Photo Albums.");
        subscriber.add(obs);
    }

    /**
     * Delete an observer from our subsribers list.
     * @param obs Observer remove
     */
    @Override
    public void deleteObserver(Observer obs) {
        int index = subscriber.indexOf(obs);
        if (index >= 0)
        {
            System.out.println("A Subscriber left from Photo.");
            subscriber.remove(obs);
        }
    }

    /**
     * Notify All subscribers
     */
    @Override
    public void notifyToObservers() {
        System.out.println("Photo Subscribers Notified.");
        for (Observer obs: subscriber) {
            obs.update(photo_name);
        }
    }

    /**
     * Update photo names
     * @param photo new photo name
     */
    @Override
    public void changeStringMessage(String photo) {
        System.out.println("Photo name chanced with " + photo);
        this.photo_name = photo;
    }
}
