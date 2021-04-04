package hw1_part1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int n = 0;
        Scanner input = new Scanner(System.in);
        while(n <= 0)
        {
            System.out.println("Enter the matrix dimension greater than zero: ");
            n = input.nextInt();
            System.out.println("N: " + n);
        }

        double[][] mat_a = new double[n][n];
        double[] mat_b = new double[n];

        read_input(mat_a, mat_b, n);
        System.out.println("Two Dimensions Matrix A:");
        print_two_dim(mat_a, n);
        System.out.println("One Dimension Matrix B:");
        print_one_dim(mat_b, n);

        MatrixSolver mx = new MatrixSolver(new Matrix_Inversion());

        System.out.println("Matrix Inversion Result:");
        double[] solved_matrix = mx.solver(mat_a,mat_b);
        print_one_dim(solved_matrix,n);

        System.out.println("Gauss Elimination Result:");
        //mx = new MatrixSolver(new Gaussian_Elimination());
        mx.setLSolver(new Gaussian_Elimination());
        solved_matrix = mx.solver(mat_a,mat_b);
        print_one_dim(solved_matrix,solved_matrix.length);

    }

    private static void print_two_dim(double[][]mat_a, int n)
    {
        for (double[]i : mat_a) {
            for (double j:i) {
                System.out.format("%.3f",j);
            }
            System.out.println();
        }
    }

    private static void print_one_dim(double[]mat_b, int n)
    {
        for (double b:mat_b) {
            System.out.format("%.3f ",b);
            //System.out.print(b+" ");
        }
        System.out.println();
    }

    private static void read_input(double[][] mat_a, double[]mat_b, int n)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Fill the two dimensions matrix A.\n" +
                "Enter "+n*n+" numbers: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter ["+i+"]["+j+"] element: ");
                mat_a[i][j] = input.nextDouble();
            }
        }

        System.out.println("Fill the one dimension matrix B.\n" + "" +
                "Enter "+n+" numbers: ");

        for (int i = 0; i < n; i++) {
            mat_b[i] = input.nextDouble();
        }
    }
}
