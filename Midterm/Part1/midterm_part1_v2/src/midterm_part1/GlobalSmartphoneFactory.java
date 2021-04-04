package midterm_part1;

public class GlobalSmartphoneFactory implements SmartphoneFactory {
    /**
     * Create a new 24 bit Display for Global region.
     * @return a new 24 bit Display
     */
    @Override
    public Display createDisplay() {
        return new Display(24);
    }

    /**
     * Create a new 2 Cores CPU Ram Board for Global region.
     * @return a new 2 Cores CPU Ram
     */
    @Override
    public Cpu_Ram createCpu_Ram() {
        return new Cpu_Ram(2);
    }

    /**
     * Create a new Lithium-Cobalt Battery for Global region.
     * @return a new Lithium-Cobalt Battery
     */
    @Override
    public Battery createBattery() {
        return new Battery("Lithium-Cobalt");
    }

    /**
     * Create a new 32GB Maximum Capacity Storage for Global region.
     * @return a new 23GB Maximum Capacity Storage
     */
    @Override
    public Storage createStorage() {
        return new Storage(32);
    }

    /**
     * Create a new 2X Zoom Camera for Global region.
     * @return a new 2X Zoom Camera
     */
    @Override
    public Camera createCamera() {
        return new Camera(2);
    }

    /**
     * Create a new 50cm Waterproof Phone Case for Global region.
     * @return a new 50cm Waterproof Phone Case
     */
    @Override
    public PhoneCase createPhoneCase() {
        return new PhoneCase(50);
    }
}
