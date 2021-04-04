package hw2;

public class TrafficLight implements Observer{
    private Light red;
    private Light yellow;
    private Light green;
    private Light current;
    private int timeout;
    private HiTech hi;

    public TrafficLight(HiTech o, int timeout)
    {
        this.hi = o;
        this.hi.registerObserver(this);

        this.red = new RedLight(this);
        this.yellow = new YellowLight(this);
        this.green = new GreenLight(this);
        this.current = red;
        this.timeout = timeout;
    }

    /**
     * Set the light
     * @param light current light
     */
    public void setLight(Light light){
        this.current = light;
    }

    /**
     * Chance the current light
     */
    public void RedOn(){
        current = red;
        current.RedOn();
    }

    /**
     * Chance the current light
     */
    public void GreenOn(){
        current = green;
        current.GreenOn();
    }

    /**
     * Chance the current light
     */
    public void YellowOn(){
        current = yellow;
        current.YellowOn();
    }

    /**
     * get red light
     * @return red
     */
    public Light getRed(){
        return red;
    }

    /**
     * get yellow light
     * @return yellow
     */
    public Light getYellow(){
        return yellow;
    }

    /**
     * get green light
     * @return green
     */
    public Light getGreen(){
        return green;
    }

    /**
     * Count the time and chance the lights.
     */
    public void chanceLight()
    {
        for (int i = 1; i <= timeout+18; i++) {

            if (i == 1 || i == 15){
                current.RedOn();
                System.out.println("Time: " + i + " " + current);
            }
            if (i == 16 || i == timeout + 15){
                current.GreenOn();
                System.out.println("Time: " + i + " " + current);
            }
            if (i == timeout+16 || i == timeout+18){
                current.YellowOn();
                System.out.println("Time: " + i + " " + current);
            }
        }
    }

    /**
     * Take the timeout. Update time.
     * @param time timeout
     */
    @Override
    public void update(int time) {
        this.timeout = time;
        this.chanceLight();
    }
}
