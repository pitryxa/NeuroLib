package neuro.activating;

public class SimpleLinear extends ActivatingFunction{

    @Override
    public Double run(Double x) {
        return x;
    }

    @Override
    public Double derivative(Double result) {
        return 1.;
    }
}
