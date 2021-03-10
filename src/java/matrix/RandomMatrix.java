package matrix;

import java.util.Random;
import java.util.function.Function;

public class RandomMatrix extends Matrix {

    public RandomMatrix(int rows, int cols) {
        super(rows, cols);
        this.matrix = random();
    }

    public RandomMatrix(int rows, int cols, double start, double end) {
        super(rows, cols);
        if (!validate.isValidRange(start, end)) {
            throw new IllegalArgumentException("Invalid range: the start number must be less than the end number.");
        }
        this.matrix = random(start, end);
    }

    public RandomMatrix(int rows, int cols, Function<Random, Integer> creator) {
        super(rows, cols);
        this.matrix = random(creator);
    }

    protected Double[][] random() {
        Random rnd = new Random();
        Double[][] data = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = rnd.nextDouble();
            }
        }
        return data;
    }

    protected Double[][] random(double start, double end) {
        Random rnd = new Random();
        Double[][] data = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = rnd.nextDouble() * (end - start) + start;
            }
        }
        return data;
    }

    protected Double[][] random(Function<Random, Integer> creator) {
        Random rnd = new Random();
        Double[][] data = new Double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = Double.valueOf(creator.apply(rnd));
            }
        }
        return data;
    }
}
