package vector;

public class AdditionVector extends Vector{

    public AdditionVector(Vector aVector, Vector bVector) {
        super(aVector.size);
        if (!validate.isSameSize(aVector, bVector)) {
            throw new IllegalArgumentException("Both vectors must have the same size.");
        }
        this.vector = addition(aVector, bVector);
    }

    protected Double[] addition(Vector aVector, Vector bVector) {

        Double[] data = new Double[size];
        for (int i = 0; i < size; i++) {
            data[i] = aVector.vector[i] + bVector.vector[i];
        }
        return data;
    }
}
