package midterm_part1;

public class TurkeySmartphoneMarket extends SmartphoneMarket {
    /**
     * We take this method from Smartphone abstract class. Then, create a smartphone model.
     * @param type types of Smartphones
     * @return new specific smartphone.
     */
    @Override
    protected Smartphone createSmartphone(String type) {
        Smartphone s = null;
        SmartphoneFactory factory = new TurkeySmartphoneFactory();

        switch (type) {
            case "IflasDeluxe":
                s = new IflasDeluxe(factory);
                s.setName("Iflas Delux in Turkey Factory\n");
                break;
            case "MaximumEffort":
                s = new MaximumEffort(factory);
                s.setName("Maximum Effort in Turkey Factory\n");
                break;
            case "Aman-Iflas":
                s = new AmanIflas(factory);
                s.setName("I-I-Aman Iflas in Turkey Factory\n");
                break;
            default:
                System.out.println("UNKNOWN TYPE");
                break;
        }

        return s;
    }
}
