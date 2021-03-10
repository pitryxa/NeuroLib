package matrix;

import java.util.Objects;

public class Matrix implements Cloneable {
    protected final int rows;
    protected final int cols;
    protected Double[][] matrix;
    protected final ValidateMatrix validate = new ValidateMatrix();

    public Matrix(int rows, int cols) {
        if (!validate.isValid(rows) || !validate.isValid(cols)) {
            throw new IllegalArgumentException("The number of rows and cols must be greater than zero.");
        }
        this.rows = rows;
        this.cols = cols;
        this.matrix = new Double[rows][cols];
        validate.setDimensions(rows, cols);
    }

    public Matrix(Double[][] extArray) {
        int rows = extArray.length;
        if (!validate.isValid(rows)) {
            throw new IllegalArgumentException("The number of rows must be greater than zero.");
        }
        int cols = extArray[0].length;
        if (!validate.isValid(cols)) {
            throw new IllegalArgumentException("The number of cols must be greater than zero.");
        }
        this.matrix = extArray;
        this.rows = rows;
        this.cols = cols;
        validate.setDimensions(rows, cols);
    }

    public Matrix(Matrix extMatrix) {
        this.rows = extMatrix.rows;
        this.cols = extMatrix.cols;
        this.matrix = extMatrix.matrix;
        validate.setDimensions(rows, cols);
    }

    public Double[][] toArray() {
        return matrix;
    }

    public Double get(int row, int col) {
        if (!validate.isIndexesValid(row, col)) {
            throw new IllegalArgumentException("The indexes out of range.");
        }
        return matrix[row][col];
    }

    public void put(int row, int col, Double data) {
        if (!validate.isIndexesValid(row, col)) {
            throw new IllegalArgumentException("The indexes out of range.");
        }
        matrix[row][col] = data;
    }

    public Double[] getRow(int row) {
        if (!validate.isRowIndexValid(row)) {
            throw new IllegalArgumentException("The index of row out of range.");
        }
        return matrix[row];
    }

    public Double[] getCol(int col) {
        if (!validate.isColIndexValid(col)) {
            throw new IllegalArgumentException("The index of col out of range.");
        }
        Double[] data = new Double[rows];
        for (int i = 0; i < rows; i++) {
            data[i] = matrix[i][col];
        }
        return data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < rows; i++) {
            if (i != 0)
                sb.append(" ");
            sb.append("[");
            for (int j = 0; j < cols; j++) {
                sb.append(matrix[i][j]);
                if (j != cols - 1)
                    sb.append(", ");
            }
            sb.append("]");
            if (i != rows - 1)
                sb.append(",\n");
            else
                sb.append("]\n");
        }
        return sb.toString();
    }

    public Matrix clone() {
        Double[][] data = new Double[rows][cols];
        Matrix m = null;
        try {
            m = (Matrix) super.clone();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    m.put(i, j, this.matrix[i][j]);
                }
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return m;
    }

    public int hashCode() {
        int hashCode = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Double e = matrix[i][j];
                hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
            }
        }
        return hashCode;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Matrix)) {
            return false;
        }

        Matrix other = (Matrix) o;
        if (this.size() != other.size() || this.rows != other.rows) {
            return false;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!Objects.equals(this.matrix[i][j], other.matrix[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

    public int size() {
        return rows * cols;
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }



}
