package midterm_part1;

public class Battery {
    private int h;
    private int mah;
    private String type;

    /**
     * Create a new battery object
     * @param h feature 1
     * @param mah feature 2
     */
    public Battery(int h, int mah)
    {
        this.h = h;
        this.mah = mah;
    }

    /**
     * set battery type
     * @param type feature 3
     */
    public Battery(String type)
    {
        this.type = type;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getMah() {
        return mah;
    }

    public void setMah(int mah) {
        this.mah = mah;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString()
    {
        String name = "Battery: " + getH() + " H, " + getMah() + " mAh, " + getType() + " type.\n";
        return name;
    }

}
