package midterm_part1;

public class Main {

    public static void main(String[] args) {
	// write your code here

        SmartphoneMarket tr = new TurkeySmartphoneMarket();
        Smartphone phone1 = tr.makeSmartphone("IflasDeluxe");
        System.out.println(phone1);
        System.out.println();

        SmartphoneMarket eu = new EUSmartphoneMarket();
        Smartphone phone2 = eu.makeSmartphone("Aman-Iflas");
        System.out.println(phone2);
        System.out.println();

        SmartphoneMarket global = new GlobalSmartphoneMarket();
        Smartphone phone3 = global.makeSmartphone("MaximumEffort");
        System.out.println(phone3);

    }
}
