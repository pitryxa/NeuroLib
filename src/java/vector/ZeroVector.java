package vector;

public class ZeroVector extends Vector{

    public ZeroVector(int size) {
        super(size);
        for (int i = 0; i < size; i++) {
            vector[i] = 0.0;
        }
    }
}
