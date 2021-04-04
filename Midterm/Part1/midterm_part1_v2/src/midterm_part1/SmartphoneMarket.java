package midterm_part1;

public abstract class SmartphoneMarket {

    /**
     * This abstract method will implement in Region's Markets.
     * It select the types of smartphones.
     * @param type types of Smartphones
     * @return new specific smartphone object
     */
    protected abstract Smartphone createSmartphone(String type);

    /**
     * The specific market's model smartphone creates in this method. Other markets create a new model and
     * we create this phone.
     * @param type type of smartphone
     * @return new specific smartphone
     */
    Smartphone makeSmartphone(String type)
    {
        Smartphone s = createSmartphone(type);

        s.createPhone();

//        s.attachCpu_Ram();
//        s.attachDisplay();
//        s.attachBattery();
//        s.attachStorage();
//        s.attachCamera();
//        s.attachPhoneCase();

        return s;
    }

}
