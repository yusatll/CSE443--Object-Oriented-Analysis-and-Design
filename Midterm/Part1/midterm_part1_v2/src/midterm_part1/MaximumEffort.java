package midterm_part1;

public class MaximumEffort extends Smartphone{
    SmartphoneFactory factory;

    /**
     * Take a factory and create a special smartphone for this factory.
     * @param factory Special factory smartphone
     */
    public MaximumEffort(SmartphoneFactory factory)
    {
        this.factory = factory;
    }

    /**
     * Creating factory's smartphone and add our features about MaximumEffort model.
     */
    @Override
    void createPhone() {
        cpu_ram = factory.createCpu_Ram();
        cpu_ram.setGhz(2.8f);
        cpu_ram.setGb(8);

        display = factory.createDisplay();
        display.setInch(5.5f);

        battery = factory.createBattery();
        battery.setH(27);
        battery.setMah(3600);

        storage = factory.createStorage();
        storage.setSupport("MicroSD");
        storage.setGb(64);

        camera = factory.createCamera();
        camera.setFront(12);
        camera.setRear(8);

        phonecase = factory.createPhoneCase();
        phonecase.setSize("151x73x7.7 mm");
        phonecase.setProof1("dustproof");
        phonecase.setProof2("waterproof");
        phonecase.setMatter("aluminum");
    }
}
