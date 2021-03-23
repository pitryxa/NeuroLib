package neuro.loss;

import vector.MultiplicationVector;
import vector.SubtractionVector;
import vector.Vector;

public class MSE extends Loss {

    public MSE(double yTrue, double yPred) {
        super(yTrue, yPred);
    }

    public MSE(Vector yTrue, Vector yPred) {
        super(yTrue, yPred);
    }

    @Override
    protected double loss(Vector yTrue, Vector yPred) {
        int size = yTrue.size();
        Vector diff = new SubtractionVector(yTrue, yPred);
        Vector mult = new MultiplicationVector(diff, diff);
        return mult.get() / size;
    }

    @Override
    protected double loss(double yTrue, double yPred) {
        double diff = yTrue - yPred;
        return diff * diff;
    }
}
