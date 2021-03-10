package vector;

public class ScalarAdditionVector extends Vector{

    public ScalarAdditionVector(Vector extVector, double scalar) {
        super(extVector.size);
        this.vector = addition(extVector.vector, scalar);
    }

    protected Double[] addition(Double[] vector, double scalar) {
        Double[] data = new Double[size];
        for (int i = 0; i < size; i++) {
            data[i] = vector[i] + scalar;
        }
        return data;
    }
}
