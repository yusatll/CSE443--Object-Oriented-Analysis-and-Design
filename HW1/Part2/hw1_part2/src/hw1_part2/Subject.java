package hw1_part2;

public interface Subject {
    /**
     * A subject register Observers
     * @param obs Observer to register
     */
    void registerObserver(Observer obs);

    /**
     * A subject can remove Observers
     * @param obs Observer remove
     */
    void deleteObserver(Observer obs);

    /**
     * A subject notify to Observers.
     */
    void notifyToObservers();

    /**
     * Set its news
     * @param msg It's news.
     */
    void changeStringMessage(String msg);
}
