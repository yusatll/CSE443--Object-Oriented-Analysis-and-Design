package midterm_part1;

public class AmanIflas extends Smartphone {
    SmartphoneFactory factory;

    /**
     * Take a factory and create a special smartphone for this factory.
     * @param factory Special factory smartphone
     */
    public AmanIflas(SmartphoneFactory factory)
    {
        this.factory = factory;
    }

    /**
     * Creating factory's smartphone and add our features about AmanIflas model.
     */
    @Override
    void createPhone() {
        cpu_ram = factory.createCpu_Ram();
        cpu_ram.setGhz(2.2f);
        cpu_ram.setGb(4);

        display = factory.createDisplay();
        display.setInch(4.5f);

        battery = factory.createBattery();
        battery.setH(16);
        battery.setMah(2000);

        storage = factory.createStorage();
        storage.setSupport("MicroSD");
        storage.setGb(16);

        camera = factory.createCamera();
        camera.setFront(8);
        camera.setRear(5);

        phonecase = factory.createPhoneCase();
        phonecase.setSize("143x69x7.3 mm");
        phonecase.setProof1("waterproof");
        phonecase.setMatter("plastic");

    }
}
