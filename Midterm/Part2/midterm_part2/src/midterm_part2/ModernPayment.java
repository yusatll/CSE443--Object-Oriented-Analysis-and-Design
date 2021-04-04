package midterm_part2;

public interface ModernPayment {
    /**
     * We want to use this method.
     * @param cardNo str
     * @param amount float
     * @param destination str
     * @param installments str
     * @return int
     */
    int pay(String cardNo, float amount, String destination, String installments);
}
