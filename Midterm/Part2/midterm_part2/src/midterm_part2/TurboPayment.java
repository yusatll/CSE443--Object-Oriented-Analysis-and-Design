package midterm_part2;

public interface TurboPayment {
    /**
     * The old method which is we don't know the implementation.
     * @param turboCardNo str
     * @param turboAmount float
     * @param destinationTurboOfCourse str
     * @param installmentsButInTurbo str
     * @return int
     */
    int payInTurbo(String turboCardNo, float turboAmount,
                   String destinationTurboOfCourse, String installmentsButInTurbo);
}
