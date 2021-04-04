package midterm_part2;

public class ModernPaymentClass implements ModernPayment {
    /**
     * We want to use this method.
     * @param cardNo str
     * @param amount float
     * @param destination str
     * @param installments str
     * @return int
     */
    @Override
    public int pay(String cardNo, float amount, String destination, String installments) {
        System.out.println("Modern Payment Pay: \nCardNo: "+cardNo +
                "\nAmount: " + amount + "\ndestination " + destination + "\ninstallments: " + installments);
        return 1;
    }
}
