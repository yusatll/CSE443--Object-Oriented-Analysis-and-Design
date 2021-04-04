package hw1_part1;

public class Matrix_Inversion implements LinearSolver {

    /**
     * Solve with Matrix Inversion Method
     * @param matrixA get two dimensions matrix
     * @param matrixB get one dimension matrix
     * @return solved one dimension matrix
     */
    @Override
    public double[] solve(double[][] matrixA, double[] matrixB) {
        /* Cofactor Matrix A   */
        int len = matrixA.length;
        double[][] inverse = inverse(matrixA);

        double[] result = new double[matrixB.length];
        for (int i = 0; i < inverse.length; i++) {
            double t = 0.0;
            for (int j = 0; j < inverse[i].length; j++) {
                t += inverse[i][j] * matrixB[j];
            }
            result[i] = t;
        }

        return result;
    }

    private double[][] cofactore(double[][]A, int p, int q)
    {
        int i=0,j=0;
        double[][] cof = new double[A.length][A.length];

        for (int k = 0; k < A.length; k++) {
            for (int l = 0; l < A.length; l++) {
                if (k != p && l != q) {
                    cof[i][j++] = A[k][l];
                    if (j == A.length - 1) {
                        j=0;
                        i++;
                    }
                }
            }
        }
        return cof;
    }

    private double determinant(double[][] A, int k)
    {
        double result = 0.0;
        if (k == 1)
            return A[0][0];

        double[][] co;
        int sing = 1;
        for (int i = 0; i < k; i++) {
            co = cofactore(A,0,i);
            result += sing * A[0][i] * determinant(co,k-1);
            sing *= -1;
        }
        return result;
    }

    private double[][] adjoint(double[][]A)
    {
        double[][] adj_matrix = new double[A.length][A.length];
        if (A.length == 1) {
            adj_matrix[0][0] = 1;
            return adj_matrix;
        }

        int sign = 1;
        double[][] cof;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                cof = cofactore(A,i,j);
                if ((i+j) % 2 == 0)
                    sign = 1;
                else
                    sign = -1;
                adj_matrix[j][i] = sign * determinant(cof,A.length-1);
            }
        }
        return adj_matrix;
    }

    private double[][] inverse(double[][] A)
    {
        double det = determinant(A,A.length);
        if (det == 0) {
            System.out.println("Con not find inverse.");
            return A;
        }
        double[][] inverse = new double[A.length][A.length];
        double[][] adj = adjoint(A);

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                inverse[i][j] = adj[i][j] / det;
            }
        }

        return inverse;
    }

}
