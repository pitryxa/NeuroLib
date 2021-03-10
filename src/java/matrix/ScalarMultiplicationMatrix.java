package matrix;

public class ScalarMultiplicationMatrix extends Matrix {


    public ScalarMultiplicationMatrix(Matrix extMatrix, double scalar) {
        super(extMatrix.rows, extMatrix.cols);
        this.matrix = scalarMultiplication(extMatrix.matrix, scalar);
    }

    protected Double[][] scalarMultiplication(Double[][] matrix, double scalar) {
        Double[][] data = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = matrix[i][j] * scalar;
            }
        }
        return data;
    }
}
