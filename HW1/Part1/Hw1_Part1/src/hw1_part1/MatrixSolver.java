package hw1_part1;

public class MatrixSolver {
    LinearSolver LSolver;

    /**
     * Set solver method
     * @param ls set linear solver
     */
    public MatrixSolver(LinearSolver ls)
    {
        this.LSolver = ls;
    }

    /**
     * Chance linear solver
     * @param lin_solver set new linear solver
     */
    public void setLSolver(LinearSolver lin_solver)
    {
        System.out.println("Solving Method has been changed in run time.");
        this.LSolver = lin_solver;
    }

    /**
     * Call the solver which Linear solver called
     * @param matrixA two dimensions matrix
     * @param matrixB one dimension matrix
     * @return call linear solver solve method
     */
    public double[] solver(double[][]matrixA, double[]matrixB)
    {
        return  LSolver.solve(matrixA,matrixB);
    }

}
