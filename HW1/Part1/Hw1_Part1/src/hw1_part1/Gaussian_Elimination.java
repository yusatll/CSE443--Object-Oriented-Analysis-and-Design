package hw1_part1;

public class Gaussian_Elimination implements LinearSolver {
    /**
     * Solve with Gaussian Elimination method
     * @param matrixA get two dimensions matrix
     * @param matrixB get one dimension matrix
     * @return solved one dimension matrix
     */
    @Override
    public double[] solve(double[][] matrixA, double[] matrixB) {
        int len = matrixB.length;

        for (int i = 0; i < len; i++) {
            int m = i;
            for (int j = i+1; j < len; j++) {
                if (Math.abs(matrixA[j][i]) > Math.abs(matrixA[m][i]))
                    m = j;
            }
            double[] temp = matrixA[i];
            matrixA[i] = matrixA[m];
            matrixA[m] = temp;

            double b = matrixB[i];
            matrixB[i] = matrixB[m];
            matrixB[m] = b;

            for (int j = i+1; j < len; j++) {
                double a = matrixA[j][i] / matrixA[i][i];
                matrixB[j] -= a * matrixB[i];
                for (int k = i; k < len; k++) {
                    matrixA[j][k] -= a * matrixA[i][k];
                }
            }
        }

        double[] result = new double[len];
        for (int i = len-1; i >= 0 ; i--) {
            double total = 0.0;
            for (int j = i+1; j < len; j++) {
                total += matrixA[i][j] * result[j];
            }
            result[i] = (matrixB[i] - total) / matrixA[i][i];
        }
        return result;
    }
}
