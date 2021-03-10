package vector;

public class ScalarMultiplicationVector extends Vector {

    public ScalarMultiplicationVector(Vector extVector, double scalar) {
        super(extVector);
        this.vector = multiplication(extVector.vector, scalar);
    }

    private Double[] multiplication(Double[] vector, double scalar) {
        Double[] data = new Double[size];
        for (int i = 0; i < size; i++) {
            data[i] = vector[i] * scalar;
        }
        return data;
    }
}
