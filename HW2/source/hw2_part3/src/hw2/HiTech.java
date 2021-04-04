package hw2;

import java.util.ArrayList;

public class HiTech implements Subject{
    private ArrayList observers;
    private int timeout;

    public HiTech(){
        observers = new ArrayList();
    }

    /**
     * if flag is true, it means the traffic has increased substantially,
     * otherwise (if false), everything is normal,
     * so timeout_X returns to its initial value.
     * @param flag chance the timeout
     */
    public void changeDetected(boolean flag){
        // ????
        if (flag){
            timeout = 90;
        }
        else {
            timeout = 60;
        }
        notifyObservers();
    }

    /**
     * Subscribe observer
     * @param o observer
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * remove obsserver
     * @param o observer
     */
    @Override
    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if (index >= 0){
            observers.remove(index);
        }
    }

    /**
     * Update all observers.
     */
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer obs  = (Observer) observers.get(i);
            obs.update(timeout);
        }
    }
}
