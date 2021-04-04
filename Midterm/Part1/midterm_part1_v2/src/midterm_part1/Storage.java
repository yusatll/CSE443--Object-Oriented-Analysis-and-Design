package midterm_part1;

public class Storage {
    private String support;
    private int gb;
    private int max_gb;

    public Storage(String sup, int gb)
    {
        this.support = sup;
        this.gb = gb;
    }

    public Storage(int max)
    {
        this.max_gb = max;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public int getGb() {
        return gb;
    }

    public void setGb(int gb) {
        this.gb = gb;
    }

    public int getMax_gb() {
        return max_gb;
    }

    public void setMax_gb(int max_gb) {
        this.max_gb = max_gb;
    }

    public String toString()
    {
        String name = "Storage: " + getSupport() + " Support, " + getGb() + " GB," + getMax_gb() + " Max GB.\n";
        return name;
    }

}
