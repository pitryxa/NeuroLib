package vector;

public class MultiplicationVector extends Vector{

    public MultiplicationVector(Vector aVector, Vector bVector) {
        super(1);
        if (!validate.isSameSize(aVector, bVector)) {
            throw new IllegalArgumentException("Both vectors must have the same size.");
        }
        this.vector = multiplication(aVector, bVector);
    }

    protected Double[] multiplication(Vector aVector, Vector bVector) {
        double sum = 0;
        for (int i = 0; i < aVector.size; i++) {
            sum += aVector.vector[i] * bVector.vector[i];
        }
        return new Double[]{sum};
    }

    public Double get() {
        return vector[size];
    }

}
