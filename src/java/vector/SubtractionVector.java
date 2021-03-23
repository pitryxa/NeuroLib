package vector;

public class SubtractionVector extends Vector {

    public SubtractionVector(Vector aVector, Vector bVector) {
        super(aVector.size);
        if (!validate.isSameSize(aVector, bVector)) {
            throw new IllegalArgumentException("Both vectors must have the same size.");
        }
        this.vector = subtraction(aVector, bVector);
    }

    private Double[] subtraction(Vector aVector, Vector bVector) {
        Double[] data = new Double[size];
        for (int i = 0; i < size; i++) {
            data[i] = aVector.vector[i] - bVector.vector[i];
        }
        return data;
    }
}
