package neuro.loss;

import vector.Vector;

public abstract class Loss {

    protected final double loss;

    Loss(double yTrue, double yPred) {
        this.loss = loss(yTrue, yPred);
    }

    Loss(Vector yTrue, Vector yPred) {
        if (!isInputCorrect(yTrue, yPred)) {
            throw new IllegalArgumentException("The vectors must be the same size.");
        }
        this.loss = loss(yTrue, yPred);
    }

    protected abstract double loss(Vector yTrue, Vector yPred);

    protected abstract double loss(double yTrue, double yPred);

    public double getLoss() {
        return loss;
    }

    protected boolean isInputCorrect(Vector yTrue, Vector yPred) {
        return yTrue.size() == yPred.size();
    }
}
