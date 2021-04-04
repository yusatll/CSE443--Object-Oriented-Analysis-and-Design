package midterm_part2;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TurboPaymentClass turboclass = new TurboPaymentClass();
        ModernPaymentClass modernclass = new ModernPaymentClass();
        TurboPayment modernAdapter = new ModernPaymentAdapter(modernclass);


        modernclass.pay("123",5.5f,"ModernDest.", "ModernInstall");
        System.out.println();

        turboclass.payInTurbo("1111", 11.1f, "TurboDest", "TurboInstall");
        System.out.println();

        modernAdapter.payInTurbo("1111",11.1f,"TurboDest","TurboInstall");

    }
}
