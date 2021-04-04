package midterm_part1;

public interface SmartphoneFactory {

    public Display createDisplay();
    public Cpu_Ram createCpu_Ram();
    public Battery createBattery();
    public Storage createStorage();
    public Camera createCamera();
    public PhoneCase createPhoneCase();

}
