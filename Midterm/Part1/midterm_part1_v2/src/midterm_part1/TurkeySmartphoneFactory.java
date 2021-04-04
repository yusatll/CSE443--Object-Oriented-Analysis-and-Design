package midterm_part1;

public class TurkeySmartphoneFactory implements SmartphoneFactory {
    @Override
    public Display createDisplay() {
        return new Display(32);
    }

    @Override
    public Cpu_Ram createCpu_Ram() {
        return new Cpu_Ram(8);
    }

    @Override
    public Battery createBattery() { return new Battery("Lithium-Boron"); }

    @Override
    public Storage createStorage() {
        return new Storage(128);
    }

    @Override
    public Camera createCamera() {
        return new Camera(4);
    }

    @Override
    public PhoneCase createPhoneCase() {
        return new PhoneCase(200);
    }

}
