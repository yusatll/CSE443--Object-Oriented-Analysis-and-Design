package midterm_part1;

public class Display {
    private float inch;
    private int bit;

    /**
     * Normal Display object
     * @param inc feature 1
     * @param bit feature 2
     */
    public Display(float inc, int bit)
    {
        this.inch = inc;
        this.bit = bit;
    }

    /**
     * Specific Display object
     * @param inch feature 3
     */
    public Display(float inch)
    {
        this.inch = inch;
    }

    public Display(int bit)
    {
        this.bit = bit;
    }

    public float getInch() {
        return inch;
    }

    public void setInch(float inch) {
        this.inch = inch;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    public String toString()
    {
        String name = "Display " + getInch() + " inch "  + getBit() + " bit.\n";
        return name;
    }
}
