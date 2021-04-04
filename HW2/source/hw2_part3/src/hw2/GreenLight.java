package hw2;

public class GreenLight implements Light {
    TrafficLight trafficLight;

    public GreenLight(TrafficLight t){
        this.trafficLight = t;
    }


    /**
     * Can not go Red state from the Green State..
     */
    @Override
    public void RedOn() { }

    /**
     * It is already Green state.
     */
    @Override
    public void GreenOn() { }

    /**
     * Change state to Yellow state.
     */
    @Override
    public void YellowOn() {
        trafficLight.setLight(trafficLight.getYellow());
    }

    /**
     * Write Green
     * @return Green str
     */
    public String toString() {
        return "GREEN";
    }
}
