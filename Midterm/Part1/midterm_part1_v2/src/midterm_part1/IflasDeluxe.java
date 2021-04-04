package midterm_part1;

public class IflasDeluxe extends Smartphone {
    SmartphoneFactory factory;

    /**
     * Take a factory and create a special smartphone for this factory.
     * @param factory Special factory smartphone
     */
    public IflasDeluxe(SmartphoneFactory factory)
    {
        this.factory = factory;
    }

    /**
     * Creating factory's smartphone and add our features about IflasDeluxe model.
     */
    @Override
    void createPhone() {
        cpu_ram = factory.createCpu_Ram();
        cpu_ram.setGhz(2.2f);
        cpu_ram.setGb(6);

        display = factory.createDisplay();
        display.setInch(5.3f);

        battery = factory.createBattery();
        battery.setH(20);
        battery.setMah(2800);

        storage = factory.createStorage();
        storage.setSupport("MicroSD");
        storage.setGb(32);

        camera = factory.createCamera();
        camera.setFront(12);
        camera.setRear(5);

        phonecase = factory.createPhoneCase();
        phonecase.setSize("149x73x7.7 mm");
        phonecase.setProof1("waterproof");
        phonecase.setMatter("aluminum");
    }


}
