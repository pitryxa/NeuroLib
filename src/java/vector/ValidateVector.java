package vector;

public class ValidateVector {
    private int size;

    public ValidateVector() {
        this.size = 0;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isValid(int dim) {
        return dim > 0;
    }

    public boolean isIndexValid(int index) {
        return index >= 0 && index < size;
    }

    public boolean isSameSize(Vector aV, Vector bV) {
        return aV.size == bV.size;
    }

    public boolean isValidRange(double start, double end) {
        return start < end;
    }
}
