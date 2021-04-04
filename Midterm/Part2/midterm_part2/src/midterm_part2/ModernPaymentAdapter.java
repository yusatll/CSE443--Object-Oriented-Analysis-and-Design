package midterm_part2;

public class ModernPaymentAdapter implements TurboPayment {
    ModernPayment modern;

    /**
     * Take a ModernPayment object and run its method.
     * @param pay Modern payment
     */
    public ModernPaymentAdapter(ModernPayment pay) {
        this.modern = pay;
    }

    /**
     * We have an old TurboPayment but We want to use Modern Payment.
     * This method comes from Turbo Payment but inside we use ModernPayment method.
     * @param turboCardNo str
     * @param turboAmount float
     * @param destinationTurboOfCourse str
     * @param installmentsButInTurbo str
     * @return int
     */
    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        System.out.println("In adapter class, Call Modern Payment Pay method.");
        modern.pay(turboCardNo,turboAmount,destinationTurboOfCourse, installmentsButInTurbo);
        return 0;
    }
}
