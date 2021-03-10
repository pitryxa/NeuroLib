package matrix;

public class ScalarAdditionMatrix extends Matrix {


    public ScalarAdditionMatrix(Matrix extMatrix, double scalar) {
        super(extMatrix.rows, extMatrix.cols);
        this.matrix = addition(extMatrix.matrix, scalar);
    }

    protected Double[][] addition(Double[][] matrix, double scalar) {
        Double[][] data = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = matrix[i][j] + scalar;
            }
        }
        return data;
    }
}
