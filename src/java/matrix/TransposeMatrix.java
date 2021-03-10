package matrix;

public class TransposeMatrix extends Matrix {

    public TransposeMatrix(Matrix matrix) {
        super(matrix.cols, matrix.rows);
        this.matrix = transpose(matrix);
    }

    protected Double[][] transpose(Matrix matrix) {
        Double[][] data = new Double[rows][cols];
        Double[][] m = matrix.toArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = m[j][i];
            }
        }
        return data;
    }
}
