package hw2;

public class YellowLight implements Light {

    TrafficLight trafficLight;

    public YellowLight(TrafficLight t){
        this.trafficLight = t;
    }

    /**
     * Change state to Red state.
     */
    @Override
    public void RedOn() {
        trafficLight.setLight(trafficLight.getRed());
    }

    /**
     * Can not go to Green state from the Yellow state.
     */
    @Override
    public void GreenOn() { }

    /**
     * It is already Yellow state.
     */
    @Override
    public void YellowOn() { }

    /**
     * Write state name
     * @return Yellow str
     */
    public String toString() {
        return "YELLOW";
    }
}
