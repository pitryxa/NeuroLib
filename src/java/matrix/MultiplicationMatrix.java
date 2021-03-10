package matrix;

public class MultiplicationMatrix extends Matrix{

    public MultiplicationMatrix(Matrix aMatrix, Matrix bMatrix) {
        super(aMatrix.rows, bMatrix.cols);
        if (!validate.isAColsEqualBRows(aMatrix, bMatrix)) {
            throw new IllegalArgumentException("The number of cols of the matrix 'A' must be equal the number of rows of the matrix 'B'");
        }
        this.matrix = multiplication(aMatrix, bMatrix);
    }

    protected Double[][] multiplication(Matrix aMatrix, Matrix bMatrix) {
        Double[][] data = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = dotProduct(aMatrix.getRow(i), bMatrix.getCol(j));
            }
        }
        return data;
    }

    protected Double dotProduct(Double[] aVector, Double[] bVector) {
        double sum = 0;
        for (int i = 0; i < aVector.length; i++) {
            sum += aVector[i] * bVector[i];
        }
        return sum;
    }
}
