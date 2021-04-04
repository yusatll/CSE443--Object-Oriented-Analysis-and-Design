package hw2;

public class RedLight implements Light{
    TrafficLight trafficLight;

    public RedLight(TrafficLight t){
        this.trafficLight = t;
    }

    /**
     * It is already Red state
     */
    @Override
    public void RedOn() { }

    /**
     * Change state to Green from Red state.
     */
    @Override
    public void GreenOn() {
        trafficLight.setLight(trafficLight.getGreen());
    }

    /**
     * Can not go to Yellow state from the Red state.
     */
    @Override
    public void YellowOn() { }

    /**
     * Write state name.
     * @return Red str.
     */
    public String toString() {
        return "RED";
    }
}
