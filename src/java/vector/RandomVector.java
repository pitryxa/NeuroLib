package vector;

import java.util.Random;
import java.util.function.Function;

public class RandomVector extends Vector{

    public RandomVector(int size) {
        super(size);
        this.vector = random();
    }

    public RandomVector(int size, double start, double end) {
        super(size);
        if (!validate.isValidRange(start, end)) {
            throw new IllegalArgumentException("Invalid range: the start number must be less than the end number.");
        }
        this.vector = random(start, end);
    }

    public RandomVector(int size, Function<Random, Integer> creator) {
        super(size);
        this.vector = random(creator);
    }

    protected Double[] random() {
        Random rnd = new Random();
        Double[] data = new Double[size];
        for (int i = 0; i < size; i++) {
            data[i] = rnd.nextDouble();
        }
        return data;
    }

    protected Double[] random(double start, double end) {
        Random rnd = new Random();
        Double[] data = new Double[size];
        for (int i = 0; i < size; i++) {
            data[i] = rnd.nextDouble() * (end - start) + start;
        }
        return data;
    }

    protected Double[] random(Function<Random, Integer> creator) {
        Random rnd = new Random();
        Double[] data = new Double[size];
        for (int i = 0; i < size; i++) {
            data[i] = Double.valueOf(creator.apply(rnd));
        }
        return data;
    }
}
