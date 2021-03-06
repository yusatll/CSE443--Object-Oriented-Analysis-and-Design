package midterm_part1;

public class GlobalSmartphoneMarket extends SmartphoneMarket {
    /**
     * Crate a new Smartphone Model for Global Region
     * @param type Smartphone Model type
     * @return Specific smartphone model in Global
     */
    @Override
    protected Smartphone createSmartphone(String type) {
        Smartphone s = null;
        SmartphoneFactory factory = new GlobalSmartphoneFactory();

        if (type.equals("IflasDeluxe")) {
            s = new IflasDeluxe(factory);
            s.setName("Iflas Delux in Global Factory\n");
        }
        else if (type.equals("MaximumEffort")) {
            s = new MaximumEffort(factory);
            s.setName("Maximum Effort in Global Factory\n");
        }
        else if (type.equals("Aman-Iflas")) {
            s = new AmanIflas(factory);
            s.setName("I-I-Aman Iflas in Global Factory\n");
        }
        else
            System.out.println("UNKNOWN TYPE");

        return s;
    }
}
