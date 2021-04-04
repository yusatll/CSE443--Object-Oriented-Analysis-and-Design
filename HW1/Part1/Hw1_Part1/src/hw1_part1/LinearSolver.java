package hw1_part1;

public interface LinearSolver {
    /**
     *
     * @param matrixA get two dimensions matrix
     * @param matrixB get one dimension matrix
     * @return solved one dimension matrix
     */
    double[] solve(double[][] matrixA, double[] matrixB);
}
