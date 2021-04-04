package midterm_part1;

public class EUSmartphoneFactory implements SmartphoneFactory {

    /**
     * Create a new 24 bits Display for EU region.
     * @return 24 bits Display
     */
    @Override
    public Display createDisplay() {
        return new Display(24);
    }

    /**
     * Create a new 4 Cores CPU Ram for EU region.
     * @return 4 Cores CPU Ram
     */
    @Override
    public Cpu_Ram createCpu_Ram() {
        return new Cpu_Ram(4);
    }

    /**
     * Create a new Lithium_Ion Battery for EU region.
     * @return Lithium-Ion
     */
    @Override
    public Battery createBattery() {
        return new Battery("Lithium-Ion");
    }

    /**
     * Create a new 64 GB Maximum Capacity Storage for EU region.
     * @return Maximum capacity 64GB storage
     */
    @Override
    public Storage createStorage() {
        return new Storage(64);
    }

    /**
     * Create a new 3X Zoom Camera for EU region.
     * @return 3X Zoom camera
     */
    @Override
    public Camera createCamera() {
        return new Camera(3);
    }

    /**
     * Create 1m Waterproof Phone Case for EU region.
     * @return 1m waterproof phonecase
     */
    @Override
    public PhoneCase createPhoneCase() {
        return new PhoneCase(100);
    }
}
