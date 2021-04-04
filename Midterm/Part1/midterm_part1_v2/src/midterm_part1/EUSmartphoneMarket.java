package midterm_part1;

public class EUSmartphoneMarket extends SmartphoneMarket {
    /**
     * Crate a new Smartphone Model for EU region.
     * @param type Smartphone Model type
     * @return Specific smartphone model in EU
     */
    @Override
    protected Smartphone createSmartphone(String type) {
        Smartphone s = null;
        SmartphoneFactory factory = new EUSmartphoneFactory();

        if (type.equals("IflasDeluxe")) {
            s = new IflasDeluxe(factory);
            s.setName("Iflas Delux in EU Factory\n");
        }
        else if (type.equals("MaximumEffort")) {
            s = new MaximumEffort(factory);
            s.setName("Maximum Effort in EU Factory\n");
        }
        else if (type.equals("Aman-Iflas")) {
            s = new AmanIflas(factory);
            s.setName("I-I-Aman Iflas in EU Factory\n");
        }
        else
            System.out.println("UNKNOWN TYPE");

        return s;
    }
}
