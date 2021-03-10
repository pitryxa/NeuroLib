package neuro.activating;

import static java.lang.Math.exp;

public class Sigmoid extends ActivatingFunction {

    @Override
    public Double run(Double x) {
        return 1 / (1 + exp(-x));
    }
}
