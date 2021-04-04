package midterm_part2;

public class TurboPaymentClass implements TurboPayment {
    /**
     * Old method. We don't want to use it.
     * @param turboCardNo str
     * @param turboAmount float
     * @param destinationTurboOfCourse str
     * @param installmentsButInTurbo str
     * @return int
     */
    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        System.out.println("Turbo Payment PayInTurbo: TurboCardNo: "+turboCardNo +
                "\nturboAmount: " + turboAmount + "\ndestinationTurboOfCourse: " + destinationTurboOfCourse
                + "\ninstallmentsButInTurbo: " + installmentsButInTurbo);
        return 1;
    }
}
