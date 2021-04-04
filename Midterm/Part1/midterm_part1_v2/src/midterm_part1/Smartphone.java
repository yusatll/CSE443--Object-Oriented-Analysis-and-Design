package midterm_part1;

public abstract class Smartphone {
    private String name;
    Display display;
    Cpu_Ram cpu_ram;
    Battery battery;
    Storage storage;
    Camera camera;
    PhoneCase phonecase;

    /**
     * This abstract method will implement in types of smartphones(IflasDEluxe, MaximumEffort, AmanIflas).
     * They create their own smartphones.
     */
    abstract void createPhone();

//    void attachDisplay()
//    {
//        System.out.println("Display Attached.");
//    }
//    void attachCpu_Ram()
//    {
//        System.out.println("CPU Ram Board Attached.");
//    }
//    void attachBattery()
//    {
//        System.out.println("Battery Attached.");
//    }
//    void attachStorage()
//    {
//        System.out.println("Storage Attached.");
//    }
//    void attachCamera()
//    {
//        System.out.println("Camera Attached.");
//    }
//    void attachPhoneCase()
//    {
//        System.out.println("Phone Case Attached.");
//    }

    public String toString()
    {
        StringBuffer result = new StringBuffer();
        result.append(name);

        result.append(cpu_ram);
        result.append(display);
        result.append(battery);
        result.append(storage);
        result.append(camera);
        result.append(phonecase);

        return result.toString();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
