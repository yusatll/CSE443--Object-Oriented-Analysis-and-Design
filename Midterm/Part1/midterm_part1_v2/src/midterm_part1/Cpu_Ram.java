package midterm_part1;

public class Cpu_Ram {
    private float ghz;
    private int gb;
    private int core;


    /**
     * Normal CPU Ram object
     * @param ghz feature 1
     * @param gb feature 2
     */
    public Cpu_Ram(float ghz, int gb)
    {
        this.ghz = ghz;
        this.gb = gb;
    }

    /**
     * Specific CPU Ram object
     * @param core feature 3
     */
    public Cpu_Ram(int core)
    {
        this.core = core;
    }

    public float getGhz() {
        return ghz;
    }

    public void setGhz(float ghz) {
        this.ghz = ghz;
    }

    public int getGb() {
        return gb;
    }

    public void setGb(int gb) {
        this.gb = gb;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public String toString()
    {
        String name = "CPU RAM Board: " + getGhz() + " Ghz, " + getGb() + " GB, " + getCore() + " Cores.\n";
        return name;
    }
}
