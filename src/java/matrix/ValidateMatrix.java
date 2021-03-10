package matrix;

public class ValidateMatrix {
    private int rows;
    private int cols;

    public ValidateMatrix() {
        this.rows = 0;
        this.cols = 0;
    }

    public void setDimensions(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public boolean isIndexesValid(int row, int col) {
        return isRowIndexValid(row) && isColIndexValid(col);
    }

    public boolean isValid(int dim) {
        return dim > 0;
    }

    public boolean isRowIndexValid(int index) {
        return index >= 0 && index < this.rows;
    }

    public boolean isColIndexValid(int index) {
        return index >= 0 && index < this.cols;
    }

    public boolean isSameSize(Matrix aM, Matrix bM) {
        return aM.rows == bM.rows && aM.cols == bM.cols;
    }

    public boolean isAColsEqualBRows(Matrix aM, Matrix bM) {
        return aM.cols == bM.rows;
    }

    public boolean isValidRange(double start, double end) {
        return start < end;
    }
}
